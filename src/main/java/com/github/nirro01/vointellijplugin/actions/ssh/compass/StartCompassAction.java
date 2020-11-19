package com.github.nirro01.vointellijplugin.actions.ssh.compass;

import com.github.nirro01.vointellijplugin.settings.compass.CompassSettingsState;

public class StartCompassAction extends AbstractCompassSSHAction {

    @Override
    public String progressBarTitle() {
        return "Start Compass";
    }

    @Override
    public String getCommand() {
        return CompassSettingsState.getInstance().getJbossDirectory() + "/bin/compass.sh &";
    }
}