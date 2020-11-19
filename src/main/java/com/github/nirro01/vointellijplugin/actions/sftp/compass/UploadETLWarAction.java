package com.github.nirro01.vointellijplugin.actions.sftp.compass;

import com.github.nirro01.vointellijplugin.settings.compass.CompassSettingsState;
import com.intellij.openapi.util.Pair;

import java.util.Collections;
import java.util.List;

import static java.nio.file.Paths.get;

public class UploadETLWarAction extends AbstractCompassSFTPAction {

    @Override
    public String progressBarTitle() {
        return "Upload Compass War";
    }


    public List<Pair<String, String>> filesAndDestinationDefinition() {

        return Collections.singletonList(
                Pair.create(get(CompassSettingsState.getInstance().getCompassSourcesDirectory(), "etl-scheduler", "target", "compass-etl.war").toString(),
                        CompassSettingsState.getInstance().getJbossDirectory() + "/standalone/deployments/compass-etl.war")

        );
    }
}
