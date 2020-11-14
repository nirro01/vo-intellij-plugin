package com.github.nirro01.vointellijplugin.actions.ssh;

import com.github.nirro01.vointellijplugin.settings.AppSettingsState;

public class StopAdminAction extends AbstractSSHExecAction {
    @Override
    String getTitle() {
        return "Stop Admin";
    }

    @Override
    String getCommand() {
        return AppSettingsState.getInstance().getJbossDirectory() + "/bin/jboss_init_RIGHTV.sh stop admin";
    }
}
