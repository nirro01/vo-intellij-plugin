package com.github.nirro01.vointellijplugin.actions.rte;

import com.github.nirro01.vointellijplugin.actions.AbstractSSHExecAction;
import com.github.nirro01.vointellijplugin.settings.AppSettingsState;

public class RestartRTEAction extends AbstractSSHExecAction {

    public RestartRTEAction() {
        super("Restart RTE", AppSettingsState.getInstance().jbossDirectory + "/bin/jboss_init_RIGHTV.sh restart rte");
    }
}
