package com.github.nirro01.vointellijplugin.actions.ssh;

import com.github.nirro01.vointellijplugin.settings.AppSettingsState;

public class StopRTEAction extends AbstractSSHExecAction {

    @Override
    String getTitle() {
        return "Stop RTE";
    }

    @Override
    String getCommand() {
        return AppSettingsState.getInstance().getJbossDirectory() + "/bin/jboss_init_RIGHTV.sh stop rte";
    }
}
