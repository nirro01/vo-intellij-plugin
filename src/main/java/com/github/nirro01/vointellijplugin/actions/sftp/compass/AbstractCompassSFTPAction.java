package com.github.nirro01.vointellijplugin.actions.sftp.compass;

import com.github.nirro01.vointellijplugin.actions.common.VMDetails;
import com.github.nirro01.vointellijplugin.actions.sftp.AbstractSFTPAction;
import com.github.nirro01.vointellijplugin.settings.compass.CompassSettingsState;

public abstract class AbstractCompassSFTPAction extends AbstractSFTPAction {
    @Override
    public VMDetails getVMDetails() {
        return new VMDetails(
                CompassSettingsState.getInstance().getSshHost(),
                CompassSettingsState.getInstance().getSshUser(),
                CompassSettingsState.getInstance().getSshPassword(),
                Integer.parseInt(CompassSettingsState.getInstance().getSshPort()));
    }
}
