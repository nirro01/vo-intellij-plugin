package com.github.nirro01.vointellijplugin.actions.ssh.rightv;

import com.github.nirro01.vointellijplugin.settings.rightv.RightvSettingsState;

/*
    Removed Since it is not stable
*/
public class RestartAdminAction extends AbstractRightvSSHAction {

    @Override
    public String progressBarTitle() {
        return "Restart Admin";
    }

    @Override
    public String getCommand() {
        return RightvSettingsState.getInstance().getJbossDirectory() + "/bin/jboss_init_RIGHTV.sh restart admin";
    }
}

