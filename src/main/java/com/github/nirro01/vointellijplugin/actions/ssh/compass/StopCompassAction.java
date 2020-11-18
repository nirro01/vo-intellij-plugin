package com.github.nirro01.vointellijplugin.actions.ssh.compass;


import com.github.nirro01.vointellijplugin.settings.compass.CompassSettingsState;

public class StopCompassAction extends AbstractCompassSSHAction {

    public StopCompassAction() {
        super(CompassSettingsState.getInstance().getJbossDirectory() + "/bin/jboss_init_RIGHTV.sh restart admin");
    }

    @Override
    public String progressBarTitle() {
        return "Stop Compass";
    }

}