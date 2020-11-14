package com.github.nirro01.vointellijplugin.actions.ssh;

import com.github.nirro01.vointellijplugin.settings.AppSettingsState;

public class StartAdminAction extends AbstractSSHExecAction {

    @Override
    String getTitle() {
        return "Start Admin";
    }

    @Override
    String getCommand() {
        return AppSettingsState.getInstance().getJbossDirectory() + "/bin/jboss_init_RIGHTV.sh start admin";
    }
}
