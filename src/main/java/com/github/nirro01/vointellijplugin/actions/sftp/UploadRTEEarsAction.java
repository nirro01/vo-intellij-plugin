package com.github.nirro01.vointellijplugin.actions.sftp;

import com.github.nirro01.vointellijplugin.settings.rightv.RightvSettingsState;
import com.intellij.openapi.util.Pair;

import java.util.Arrays;
import java.util.List;

import static java.nio.file.Paths.get;

public class UploadRTEEarsAction extends AbstractSFTPAction {

    @Override
    public String getProgressBarTitle() {
        return "RTE Admin Ears";
    }

    @Override
    List<Pair<String, String>> filesAndDestinationDefinition() {

        return Arrays.asList(
                //RTEFacade.ear
                Pair.create(get(RightvSettingsState.getInstance().getRightvSourcesDirectory(), "runtime", "rte", "rte-facade", "target", "RTEFacade.ear").toString(),
                        RightvSettingsState.getInstance().getJbossDirectory() + "/rte-RIGHTV/deployments/RTEFacade.ear"),

                //NotificationServer.ear
                Pair.create(get(RightvSettingsState.getInstance().getRightvSourcesDirectory(), "runtime", "notification", "notification-server-ear", "target", "NotificationServer.ear").toString(),
                        RightvSettingsState.getInstance().getJbossDirectory() + "/rte-RIGHTV/deployments/NotificationServer.ear"),

                //NotificationFacade.ear
                Pair.create(get(RightvSettingsState.getInstance().getRightvSourcesDirectory(), "runtime", "notification", "notification-facade", "target", "NotificationFacade.ear").toString(),
                        RightvSettingsState.getInstance().getJbossDirectory() + "/rte-RIGHTV/deployments/NotificationFacade.ear")
        );
    }
}
