package com.github.nirro01.vointellijplugin.actions.ssh.compass;

import com.github.nirro01.vointellijplugin.actions.common.VMDetails;
import com.github.nirro01.vointellijplugin.actions.ssh.AbstractSSHExecAction;
import com.github.nirro01.vointellijplugin.settings.compass.CompassSettingsState;

public abstract class AbstractCompassSSHAction extends AbstractSSHExecAction {
    public AbstractCompassSSHAction(String command) {
        super(command, new VMDetails(
                CompassSettingsState.getInstance().getSshHost(),
                CompassSettingsState.getInstance().getSshUser(),
                CompassSettingsState.getInstance().getSshPassword(),
                Integer.parseInt(CompassSettingsState.getInstance().getSshPort())));
    }

}
