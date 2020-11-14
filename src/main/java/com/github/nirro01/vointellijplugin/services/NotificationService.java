package com.github.nirro01.vointellijplugin.services;

import com.intellij.notification.*;

public class NotificationService {

    private NotificationService() {
    }

    private static final String ERROR_DISPLAY_ID = "VO DevTools error notifications group";
    private static final String INFO_DISPLAY_ID = "VO DevTools info notifications group";

    public static void sendError(String title, String description) {
        NotificationGroup notificationGroup = new NotificationGroup(ERROR_DISPLAY_ID, NotificationDisplayType.BALLOON, true);
        Notification notification = notificationGroup.createNotification(title, description, NotificationType.ERROR, null);
        Notifications.Bus.notify(notification);

    }

    public static void sendInfo(String title, String description) {
        NotificationGroup notificationGroup = new NotificationGroup(INFO_DISPLAY_ID, NotificationDisplayType.NONE, true);
        Notification notification = notificationGroup.createNotification(title, description, NotificationType.INFORMATION, null);
        Notifications.Bus.notify(notification);
    }
}
