package com.github.nirro01.vointellijplugin.actions.sftp;

import com.github.nirro01.vointellijplugin.services.NotificationService;
import com.github.nirro01.vointellijplugin.settings.AppSettingsState;
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

import java.text.MessageFormat;
import java.util.List;

public abstract class AbstractSFTPAction extends AnAction {

    @Override
    public final void actionPerformed(@NotNull AnActionEvent e) {
        ProgressManager.getInstance().run(new Task.WithResult.Backgroundable(e.getProject(), getTitle()) {
            public void run(@NotNull ProgressIndicator progressIndicator) {
                progressIndicator.setIndeterminate(false);
                transferFiles(progressIndicator);

            }
        });
    }

    private void transferFiles(ProgressIndicator progressIndicator) {
        int port = Integer.parseInt(AppSettingsState.getInstance().getSshPort());
        NotificationService.sendInfo("SFTP Transfer attempt... ", buildLogMessage());
        Session session = null;
        Channel channel = null;

        try {
            session = new JSch().getSession(AppSettingsState.getInstance().getSshUser(), AppSettingsState.getInstance().getSshHost(), port);
            session.setPassword(AppSettingsState.getInstance().getSshPassword());
            session.setConfig("StrictHostKeyChecking", "no");
            progressIndicator.setFraction(0.0);
            progressIndicator.setText("creating session with host " + AppSettingsState.getInstance().getSshHost());
            session.connect();
            progressIndicator.setFraction(0.3);
            progressIndicator.setText("opening channel");
            channel = session.openChannel("sftp");
            channel.connect();
            List<Pair<String, String>> filesAndDestinationPairList = getFilesAndDestinationPairList();
            progressIndicator.setText("transferring files...");
            double singleFileFraction = 0.7 / filesAndDestinationPairList.size();
            ChannelSftp channelSftp = (ChannelSftp) channel;
            for (Pair<String, String> pair : getFilesAndDestinationPairList()) {
                channelSftp.put((pair.getFirst()), pair.getSecond());
                progressIndicator.setFraction(progressIndicator.getFraction() + singleFileFraction);
                NotificationService.sendInfo("SFTP Transfer", "transferred " + pair.getFirst());
            }
            channelSftp.exit();

        } catch (Exception e) {
            NotificationService.sendError("SSH Exec attempt failed",
                    buildLogMessage() +
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

    abstract String getTitle();

    abstract List<Pair<String, String>> getFilesAndDestinationPairList();

    private String buildLogMessage() {
        return MessageFormat.format("User: {0}, Password: {1}, Host: {2}, Port: {3}",
                AppSettingsState.getInstance().getSshUser(), AppSettingsState.getInstance().getSshPassword(), AppSettingsState.getInstance().getSshHost(), Integer.parseInt(AppSettingsState.getInstance().getSshPort()));
    }
}
