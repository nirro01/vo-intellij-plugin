package com.github.nirro01.vointellijplugin.actions.ssh.compass;

import com.github.nirro01.vointellijplugin.settings.compass.CompassSettingsState;

public class StartCompassAction extends AbstractCompassSSHAction {

    public StartCompassAction() {
        super(CompassSettingsState.getInstance().getJbossDirectory() + "/bin/compass.sh");
    }

    @Override
    public String progressBarTitle() {
        return "Start Compass";
    }

}