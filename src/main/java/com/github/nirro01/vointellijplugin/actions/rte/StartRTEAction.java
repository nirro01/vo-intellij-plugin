package com.github.nirro01.vointellijplugin.actions.rte;

import com.github.nirro01.vointellijplugin.actions.AbstractSSHExecAction;
import com.github.nirro01.vointellijplugin.settings.AppSettingsState;

public class StartRTEAction extends AbstractSSHExecAction {

    public StartRTEAction() {
        super("Start RTE", AppSettingsState.getInstance().jbossDirectory + "/bin/jboss_init_RIGHTV.sh start rte");
    }
}
