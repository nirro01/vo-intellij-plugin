package com.github.nirro01.vointellijplugin.actions.ssh.rightv;

import com.github.nirro01.vointellijplugin.actions.ssh.AbstractSSHExecAction;
import com.github.nirro01.vointellijplugin.settings.rightv.RightvSettingsState;

public abstract class AbstractRightvSSHAction extends AbstractSSHExecAction {
    public AbstractRightvSSHAction(String command) {
        super(command, new VMDetails(
                RightvSettingsState.getInstance().getSshHost(),
                RightvSettingsState.getInstance().getSshUser(),
                RightvSettingsState.getInstance().getSshPassword(),
                Integer.parseInt(RightvSettingsState.getInstance().getSshPort())));
    }

}
