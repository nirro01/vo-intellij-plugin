package com.github.nirro01.vointellijplugin.actions.ssh.rightv;

import com.github.nirro01.vointellijplugin.settings.rightv.RightvSettingsState;

public class RestartRTEAction extends AbstractRightvSSHAction {

    public RestartRTEAction() {
        super(RightvSettingsState.getInstance().getJbossDirectory() + "/bin/jboss_init_RIGHTV.sh restart rte");
    }

    @Override
    public String getProgressBarTitle() {
        return "Restart RTE";
    }

}
