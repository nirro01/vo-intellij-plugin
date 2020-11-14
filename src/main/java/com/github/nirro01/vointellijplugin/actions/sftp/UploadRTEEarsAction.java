package com.github.nirro01.vointellijplugin.actions.sftp;

import com.github.nirro01.vointellijplugin.settings.AppSettingsState;
import com.intellij.openapi.util.Pair;

import java.util.Arrays;
import java.util.List;

import static java.nio.file.Paths.get;

public class UploadRTEEarsAction extends AbstractSFTPAction {

    @Override
    String getTitle() {
        return "RTE Admin Ears";
    }

    @Override
    List<Pair<String, String>> getFilesAndDestinationPairList() {

        return Arrays.asList(
                //RTEFacade.ear
                Pair.create(get(AppSettingsState.getInstance().getRightvSourcesDirectory(), "runtime", "rte", "rte-facade", "target", "RTEFacade.ear").toString(),
                        AppSettingsState.getInstance().getJbossDirectory() + "/rte-RIGHTV/deployments/RTEFacade.ear"),

                //NotificationServer.ear
                Pair.create(get(AppSettingsState.getInstance().getRightvSourcesDirectory(), "runtime", "notification", "notification-server-ear", "target", "NotificationServer.ear").toString(),
                        AppSettingsState.getInstance().getJbossDirectory() + "/rte-RIGHTV/deployments/NotificationServer.ear"),

                //NotificationFacade.ear
                Pair.create(get(AppSettingsState.getInstance().getRightvSourcesDirectory(), "runtime", "notification", "notification-facade", "target", "NotificationFacade.ear").toString(),
                        AppSettingsState.getInstance().getJbossDirectory() + "/rte-RIGHTV/deployments/NotificationFacade.ear")
        );
    }
}
