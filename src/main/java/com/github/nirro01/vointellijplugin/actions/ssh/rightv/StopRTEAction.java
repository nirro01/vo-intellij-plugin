package com.github.nirro01.vointellijplugin.actions.ssh.rightv;

import com.github.nirro01.vointellijplugin.settings.rightv.RightvSettingsState;

public class StopRTEAction extends AbstractRightvSSHAction {

    public StopRTEAction() {
        super(RightvSettingsState.getInstance().getJbossDirectory() + "/bin/jboss_init_RIGHTV.sh stop rte");
    }

    @Override
    public String getProgressBarTitle() {
        return "Stop RTE";
    }
}
