package com.github.nirro01.vointellijplugin.actions.admin;

import com.github.nirro01.vointellijplugin.actions.AbstractSSHExecAction;
import com.github.nirro01.vointellijplugin.settings.AppSettingsState;

public class StartAdminAction extends AbstractSSHExecAction {

    public StartAdminAction() {
        super("Start Admin", AppSettingsState.getInstance().jbossDirectory + "/bin/jboss_init_RIGHTV.sh start admin");
    }
}
