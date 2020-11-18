package com.github.nirro01.vointellijplugin.actions.ssh.rightv;

import com.github.nirro01.vointellijplugin.settings.rightv.RightvSettingsState;

public class StartAdminAction extends AbstractRightvSSHAction {

    public StartAdminAction() {
        super(RightvSettingsState.getInstance().getJbossDirectory() + "/bin/jboss_init_RIGHTV.sh start admin");
    }

    @Override
    public String progressBarTitle() {
        return "Start Admin";
    }


}
