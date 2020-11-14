package com.github.nirro01.vointellijplugin.actions.admin;

import com.github.nirro01.vointellijplugin.actions.AbstractSSHExecAction;
import com.github.nirro01.vointellijplugin.settings.AppSettingsState;

public class RestartAdminAction extends AbstractSSHExecAction {

    public RestartAdminAction() {
        super("Restart Admin", AppSettingsState.getInstance().jbossDirectory + "/bin/jboss_init_RIGHTV.sh restart admin");
    }
}

