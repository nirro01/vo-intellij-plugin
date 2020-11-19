package com.github.nirro01.vointellijplugin.actions.ssh.compass;


import com.github.nirro01.vointellijplugin.settings.compass.CompassSettingsState;

public class StopCompassAction extends AbstractCompassSSHAction {


    @Override
    public String progressBarTitle() {
        return "Stop Compass";
    }

    @Override
    public String getCommand() {
        return CompassSettingsState.getInstance().getJbossDirectory() + "/bin/compass-shutdown.sh";
    }
}