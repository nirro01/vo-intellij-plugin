package com.github.nirro01.vointellijplugin.services;

import com.intellij.notification.*;
import com.intellij.openapi.progress.ProgressIndicator;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.jetbrains.annotations.NotNull;

import java.io.ByteArrayOutputStream;

public class MyApplicationService {

    public static final NotificationGroup GROUP_DISPLAY_ID_INFO =
            new NotificationGroup("VO Intellij Plugin",
                    NotificationDisplayType.TOOL_WINDOW, true);
    public void restartRTE(Project project) {

        ProgressManager.getInstance().run(new Task.WithResult.Backgroundable(project, "Restart RTE"){
            public void run(@NotNull ProgressIndicator progressIndicator) {
                runSSHCommand("ls -l", progressIndicator);
                // Finished
                progressIndicator.setFraction(1.0);
                progressIndicator.setText("finished");

            }});
    }

    public void runSSHCommand(String command, ProgressIndicator progressIndicator) {
        listFolderStructure("rightv", "rightv", "172.31.150.153", 22, command, progressIndicator);
    }

    public void listFolderStructure(String username, String password,
                                             String host, int port, String command, ProgressIndicator progressIndicator) {

        Session session = null;
        ChannelExec channel = null;

        try {
            session = new JSch().getSession(username, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            progressIndicator.setFraction(0.0);
            progressIndicator.setText("creating session with host " + host);
            session.connect();
            progressIndicator.setFraction(0.3);
            progressIndicator.setText("opening channel");
            channel = (ChannelExec) session.openChannel("exec");
            channel.setCommand(command);
            ByteArrayOutputStream responseStream = new ByteArrayOutputStream();
            channel.setOutputStream(responseStream);
            progressIndicator.setFraction(0.6);
            progressIndicator.setText("sending command " + command);
            channel.connect();
            progressIndicator.setFraction(0.8);
            progressIndicator.setText("waiting for answer...");
            while (channel.isConnected()) {
                Thread.sleep(100);
            }
            progressIndicator.setFraction(1.0);
            JBPopupFactory.getInstance().createMessage("result:" + System.lineSeparator() + new String(responseStream.toByteArray()));
            progressIndicator.setText("done");

        } catch (Exception e) {
            progressIndicator.setFraction(1.0);
            Notification notification = GROUP_DISPLAY_ID_INFO.createNotification("SSH command failed ",e.toString(), NotificationType.ERROR, null);
            Notifications.Bus.notify(notification);
            progressIndicator.setText("command failed!!");
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