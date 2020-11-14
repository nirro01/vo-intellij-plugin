package com.github.nirro01.vointellijplugin.actions.admin;

import com.github.nirro01.vointellijplugin.actions.AbstractSSHExecAction;
import com.github.nirro01.vointellijplugin.settings.AppSettingsState;

public class StopAdminAction extends AbstractSSHExecAction {

    public StopAdminAction() {
        super("Stop Admin", AppSettingsState.getInstance().jbossDirectory + "/bin/jboss_init_RIGHTV.sh stop admin");
    }
}
