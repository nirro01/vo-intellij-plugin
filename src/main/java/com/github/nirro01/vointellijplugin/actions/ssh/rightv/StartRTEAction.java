package com.github.nirro01.vointellijplugin.actions.ssh.rightv;

import com.github.nirro01.vointellijplugin.settings.rightv.RightvSettingsState;

public class StartRTEAction extends AbstractRightvSSHAction {

    public StartRTEAction() {
        super(RightvSettingsState.getInstance().getJbossDirectory() + "/bin/jboss_init_RIGHTV.sh start rte");
    }

    @Override
    public String progressBarTitle() {
        return "Start RTE";
    }

}
