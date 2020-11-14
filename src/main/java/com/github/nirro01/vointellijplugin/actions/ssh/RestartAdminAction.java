package com.github.nirro01.vointellijplugin.actions.ssh;

import com.github.nirro01.vointellijplugin.settings.AppSettingsState;

public class RestartAdminAction extends AbstractSSHExecAction {

    @Override
    String getTitle() {
        return "Restart Admin";
    }

    @Override
    String getCommand() {
        return AppSettingsState.getInstance().getJbossDirectory() + "/bin/jboss_init_RIGHTV.sh restart admin";
    }
}

