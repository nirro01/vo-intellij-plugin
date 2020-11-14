package com.github.nirro01.vointellijplugin.services;

import com.intellij.notification.*;

public class NotificationService {

    private NotificationService() {}

    public static void sendErrorBalloon(String title, String description) {
        NotificationGroup notificationGroup = new NotificationGroup("VO Intellij Plugin", NotificationDisplayType.BALLOON, true);
        Notification notification = notificationGroup.createNotification(title, description, NotificationType.ERROR, null);
        Notifications.Bus.notify(notification);

    }

    public static void infoEvent(String title, String description) {
        NotificationGroup notificationGroup = new NotificationGroup("VO Intellij Plugin", NotificationDisplayType.NONE, true);
        Notification notification = notificationGroup.createNotification(title, description, NotificationType.INFORMATION, null);
        Notifications.Bus.notify(notification);
    }
}
