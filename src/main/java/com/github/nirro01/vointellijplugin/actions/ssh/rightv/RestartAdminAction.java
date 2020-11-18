package com.github.nirro01.vointellijplugin.actions.ssh.rightv;

import com.github.nirro01.vointellijplugin.settings.rightv.RightvSettingsState;

public class RestartAdminAction extends AbstractRightvSSHAction {

    public RestartAdminAction() {
        super(RightvSettingsState.getInstance().getJbossDirectory() + "/bin/jboss_init_RIGHTV.sh restart admin");
    }

    @Override
    public String getProgressBarTitle() {
        return "Restart Admin";
    }

}
