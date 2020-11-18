package com.github.nirro01.vointellijplugin.actions.ssh;

import com.github.nirro01.vointellijplugin.actions.BackgroundAction;
import com.github.nirro01.vointellijplugin.actions.common.VMDetails;
import com.github.nirro01.vointellijplugin.services.NotificationService;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.Task;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;

public abstract class AbstractSSHExecAction extends AnAction implements BackgroundAction {

    private final String command;
    private final VMDetails vmDetails;

    public AbstractSSHExecAction(String command, VMDetails vmDetails) {
        super();
        this.command = command;
        this.vmDetails = vmDetails;
    }

    @Override
    public final void actionPerformed(@NotNull AnActionEvent e) {
        ProgressManager.getInstance().run(new Task.WithResult.Backgroundable(e.getProject(), progressBarTitle()) {
            public void run(@NotNull ProgressIndicator progressIndicator) {
                progressIndicator.setIndeterminate(false);
                runSSHCommand(command, progressIndicator);

            }
        });
    }

    private void runSSHCommand(String command, ProgressIndicator progressIndicator) {
        NotificationService.sendInfo("SSH Exec attempt... ", vmDetails.buildLogMessage());
        Session session = null;
        ChannelExec channel = null;

        try {
            session = new JSch().getSession(vmDetails.getUser(), vmDetails.getHost(), vmDetails.getPort());
            session.setPassword(vmDetails.getPassword());
            session.setConfig("StrictHostKeyChecking", "no");
            progressIndicator.setFraction(0.0);
            progressIndicator.setText("creating session with host " + vmDetails.getHost());
            session.connect();
            progressIndicator.setFraction(0.3);
            progressIndicator.setText("opening channel");
            channel = (ChannelExec) session.openChannel("exec");
            channel.setCommand(command);
            ByteArrayOutputStream responseStream = new ByteArrayOutputStream();
            channel.setOutputStream(responseStream);
            channel.connect();
            progressIndicator.setFraction(0.8);
            progressIndicator.setText("waiting for answer...");
            while (channel.isConnected()) {
                Thread.sleep(100);
            }
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

}
