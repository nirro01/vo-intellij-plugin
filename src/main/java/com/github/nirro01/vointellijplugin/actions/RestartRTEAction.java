package com.github.nirro01.vointellijplugin.actions;

import com.github.nirro01.vointellijplugin.settings.AppSettingsState;

public class RestartRTEAction extends AbstractSSHExecAction {

    @Override
    String getTitle() {
        return "Restart RTE";
    }

    @Override
    String getCommand() {
        return AppSettingsState.getInstance().getJbossDirectory() + "/bin/jboss_init_RIGHTV.sh restart rte";
    }
}
