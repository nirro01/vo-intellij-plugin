package com.github.nirro01.vointellijplugin.actions.sftp;

import com.github.nirro01.vointellijplugin.actions.BackgroundAction;
import com.github.nirro01.vointellijplugin.actions.common.VMDetails;
import com.github.nirro01.vointellijplugin.services.NotificationService;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.util.Pair;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class AbstractSFTPAction extends AnAction implements BackgroundAction {

    private final VMDetails vmDetails;

    public AbstractSFTPAction(VMDetails vmDetails) {
        this.vmDetails = vmDetails;
    }

    @Override
    public final void actionPerformed(@NotNull AnActionEvent e) {
        ProgressManager.getInstance().run(new Task.WithResult.Backgroundable(e.getProject(), progressBarTitle()) {
            public void run(@NotNull ProgressIndicator progressIndicator) {
                progressIndicator.setIndeterminate(false);
                transferFiles(progressIndicator);

            }
        });
    }

    private void transferFiles(ProgressIndicator progressIndicator) {
        NotificationService.sendInfo("SFTP Transfer attempt... ", vmDetails.buildLogMessage());
        Session session = null;
        Channel channel = null;

        try {
            session = new JSch().getSession(vmDetails.getUser(), vmDetails.getHost(), vmDetails.getPort());
            session.setPassword(vmDetails.getPassword());
            session.setConfig("StrictHostKeyChecking", "no");
            progressIndicator.setFraction(0.0);
            progressIndicator.setText("creating session with host " + vmDetails.getHost());
            session.connect();
            progressIndicator.setFraction(0.3);
            progressIndicator.setText("opening channel");
            channel = session.openChannel("sftp");
            channel.connect();
            progressIndicator.setText("transferring files...");
            List<Pair<String, String>> list = filesAndDestinationDefinition();
            double singleFileFraction = 0.7 / list.size();
            ChannelSftp channelSftp = (ChannelSftp) channel;
            for (Pair<String, String> pair : list) {
                channelSftp.put((pair.getFirst()), pair.getSecond());
                progressIndicator.setFraction(progressIndicator.getFraction() + singleFileFraction);
                NotificationService.sendInfo("SFTP Transfer", "transferred " + pair.getFirst());
            }
            channelSftp.exit();

        } catch (Exception e) {
            NotificationService.sendError("SSH Exec attempt failed",
                    vmDetails.buildLogMessage() +
                            System.lineSeparator() +
                            e.toString() +
                            System.lineSeparator() +
                            "Check your settings under File -> Settings -> Tools -> VO DevTools");
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.disconnect();
            }
            if (channel != null) {
                channel.disconnect();
            }
        }
    }

    public abstract List<Pair<String, String>> filesAndDestinationDefinition();

}
