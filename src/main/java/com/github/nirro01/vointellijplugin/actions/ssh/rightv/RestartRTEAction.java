package com.github.nirro01.vointellijplugin.actions.ssh.rightv;

import com.github.nirro01.vointellijplugin.settings.rightv.RightvSettingsState;

public class RestartRTEAction extends AbstractRightvSSHAction {

    @Override
    public String progressBarTitle() {
        return "Restart RTE";
    }

    @Override
    public String getCommand() {
        return RightvSettingsState.getInstance().getJbossDirectory() + "/bin/jboss_init_RIGHTV.sh restart rte";
    }
}
