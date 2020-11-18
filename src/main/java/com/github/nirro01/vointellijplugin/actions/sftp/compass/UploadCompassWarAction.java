package com.github.nirro01.vointellijplugin.actions.sftp.compass;

import com.github.nirro01.vointellijplugin.settings.rightv.RightvSettingsState;
import com.intellij.openapi.util.Pair;

import java.util.Arrays;
import java.util.List;

import static java.nio.file.Paths.get;

public class UploadCompassWarAction extends AbstractCompassSFTPAction {

    @Override
    public String progressBarTitle() {
        return "Upload Compass War";
    }


    public List<Pair<String, String>> filesAndDestinationDefinition() {

        return Arrays.asList(
                //translator.ear
                Pair.create(get(RightvSettingsState.getInstance().getRightvSourcesDirectory(), "admin", "translator", "translator-ear", "target", "translator.ear").toString(),
                        RightvSettingsState.getInstance().getJbossDirectory() + "/admin-RIGHTV/deployments/translator.ear")

        );
    }
}
