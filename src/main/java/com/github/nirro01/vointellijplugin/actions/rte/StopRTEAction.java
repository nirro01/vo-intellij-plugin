package com.github.nirro01.vointellijplugin.actions.rte;

import com.github.nirro01.vointellijplugin.actions.AbstractSSHExecAction;
import com.github.nirro01.vointellijplugin.settings.AppSettingsState;

public class StopRTEAction extends AbstractSSHExecAction {

    public StopRTEAction() {
        super("Stop RTE", AppSettingsState.getInstance().jbossDirectory + "/bin/jboss_init_RIGHTV.sh stop rte");
    }
}
