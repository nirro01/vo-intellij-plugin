package com.github.nirro01.vointellijplugin.actions;

import com.github.nirro01.vointellijplugin.services.NotificationService;
import com.github.nirro01.vointellijplugin.settings.AppSettingsState;
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

public class AbstractSSHExecAction extends AnAction {

    private final String title;
    private final String command;

    public AbstractSSHExecAction(String title, String command) {
        this.title = title;
        this.command = command;
    }

    @Override
    public final void actionPerformed(@NotNull AnActionEvent e) {
        ProgressManager.getInstance().run(new Task.WithResult.Backgroundable(e.getProject(), title){
            public void run(@NotNull ProgressIndicator progressIndicator) {
                progressIndicator.setIndeterminate(false);
                runSSHCommand(command, progressIndicator);

            }});
    }

    protected void runSSHCommand(String command, ProgressIndicator progressIndicator) {
        int port = Integer.parseInt(AppSettingsState.getInstance().sshPort);
        NotificationService.infoEvent("SSH Exec attempt... ", buildLogMessage(command));
        Session session = null;
        ChannelExec channel = null;

        try {
            session = new JSch().getSession(AppSettingsState.getInstance().sshUser, AppSettingsState.getInstance().sshHost, port);
            session.setPassword(AppSettingsState.getInstance().sshPassword);
            session.setConfig("StrictHostKeyChecking", "no");
            progressIndicator.setFraction(0.0);
            progressIndicator.setText("creating session with host " + AppSettingsState.getInstance().sshHost);
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
            NotificationService.sendErrorBalloon("SSH Exec attempt failed- ", buildLogMessage(command) + System.lineSeparator() + e.toString() + System.lineSeparator() + "Check your settings under File -> Settings -> Tools -> VO DevTools") ;
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

    private String buildLogMessage(String command) {
        return MessageFormat.format("User: {0}, Password: {1}, Host: {2}, Port: {3}, Command: {4}",
                AppSettingsState.getInstance().sshUser, AppSettingsState.getInstance().sshPassword, AppSettingsState.getInstance().sshHost, Integer.parseInt(AppSettingsState.getInstance().sshPort), command);
    }
}
