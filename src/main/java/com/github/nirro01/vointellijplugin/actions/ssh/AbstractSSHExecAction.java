package com.github.nirro01.vointellijplugin.actions.ssh;

import com.github.nirro01.vointellijplugin.actions.BackgroundAction;
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
import java.text.MessageFormat;

public abstract class AbstractSSHExecAction extends AnAction implements BackgroundAction {

    private String command;
    private VMDetails vmDetails;

    public AbstractSSHExecAction(String command, VMDetails vmDetails) {
        super();
        this.command = command;
        this.vmDetails = vmDetails;
    }

    @Override
    public final void actionPerformed(@NotNull AnActionEvent e) {
        ProgressManager.getInstance().run(new Task.WithResult.Backgroundable(e.getProject(), getProgressBarTitle()) {
            public void run(@NotNull ProgressIndicator progressIndicator) {
                progressIndicator.setIndeterminate(false);
                runSSHCommand(command, progressIndicator);

            }
        });
    }

    private void runSSHCommand(String command, ProgressIndicator progressIndicator) {
        NotificationService.sendInfo("SSH Exec attempt... ", buildLogMessage());
        Session session = null;
        ChannelExec channel = null;

        try {
            session = new JSch().getSession(vmDetails.user, vmDetails.host, vmDetails.port);
            session.setPassword(vmDetails.password);
            session.setConfig("StrictHostKeyChecking", "no");
            progressIndicator.setFraction(0.0);
            progressIndicator.setText("creating session with host " + vmDetails.host);
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

    private String buildLogMessage() {
        return MessageFormat.format("User: {0}, Password: {1}, Host: {2}, Port: {3}, Command: {4}",
                vmDetails.user, vmDetails.password, vmDetails.host, vmDetails.port, command);
    }

    public static class VMDetails {
        private final String host;
        private final String user;
        private final String password;
        private final int port;

        public VMDetails(String host, String user, String password, int port) {
            this.host = host;
            this.user = user;
            this.password = password;
            this.port = port;
        }
    }
}
