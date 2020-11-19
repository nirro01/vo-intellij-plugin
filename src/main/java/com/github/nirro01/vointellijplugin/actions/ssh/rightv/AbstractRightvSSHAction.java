package com.github.nirro01.vointellijplugin.actions.ssh.rightv;

import com.github.nirro01.vointellijplugin.actions.common.VMDetails;
import com.github.nirro01.vointellijplugin.actions.ssh.AbstractSSHExecAction;
import com.github.nirro01.vointellijplugin.settings.rightv.RightvSettingsState;

public abstract class AbstractRightvSSHAction extends AbstractSSHExecAction {

    @Override
    public VMDetails getVMDetails() {
        return new VMDetails(
                RightvSettingsState.getInstance().getSshHost(),
                RightvSettingsState.getInstance().getSshUser(),
                RightvSettingsState.getInstance().getSshPassword(),
                Integer.parseInt(RightvSettingsState.getInstance().getSshPort()));
    }
}
