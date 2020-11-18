package com.github.nirro01.vointellijplugin.actions.ssh.rightv;

import com.github.nirro01.vointellijplugin.settings.rightv.RightvSettingsState;

public class StopAdminAction extends AbstractRightvSSHAction {

    public StopAdminAction() {
        super(RightvSettingsState.getInstance().getJbossDirectory() + "/bin/jboss_init_RIGHTV.sh stop admin");
    }

    @Override
    public String getProgressBarTitle() {
        return "Stop Admin";
    }
}
