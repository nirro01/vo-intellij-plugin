package com.github.nirro01.vointellijplugin.actions.sftp.rightv;

import com.github.nirro01.vointellijplugin.actions.common.VMDetails;
import com.github.nirro01.vointellijplugin.actions.sftp.AbstractSFTPAction;
import com.github.nirro01.vointellijplugin.settings.rightv.RightvSettingsState;

public abstract class AbstractRightvSFTPAction extends AbstractSFTPAction {

    @Override
    public VMDetails getVMDetails() {
        return new VMDetails(
                RightvSettingsState.getInstance().getSshHost(),
                RightvSettingsState.getInstance().getSshUser(),
                RightvSettingsState.getInstance().getSshPassword(),
                Integer.parseInt(RightvSettingsState.getInstance().getSshPort()));
    }
}
