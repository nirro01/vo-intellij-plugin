package com.github.nirro01.vointellijplugin.settings.rightv;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Supports storing the application settings in a persistent way.
 * The {@link State} and {@link Storage} annotations define the name of the data and the file name where
 * these persistent application settings are stored.
 */
@State(
        name = "org.intellij.sdk.settings.rightv.RightvSettingsState",
        storages = {@Storage("SdkSettingsPlugin.xml")}
)
public class RightvSettingsState implements PersistentStateComponent<RightvSettingsState> {

    private String sshHost = "xxx.xxx.xxx.xxx";
    private String sshUser = "rightv";
    private String sshPassword = "rightv";
    private String sshPort = "22";
    private String jbossDirectory = "/home/rightv/jboss";
    private String rightvSourcesDirectory = "C:\\rightv\\sources";

    public static RightvSettingsState getInstance() {
        return ServiceManager.getService(RightvSettingsState.class);
    }

    @Nullable
    @Override
    public RightvSettingsState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull RightvSettingsState state) {
        XmlSerializerUtil.copyBean(state, this);
    }

    public String getSshHost() {
        return sshHost;
    }

    public void setSshHost(String sshHost) {
        this.sshHost = sshHost;
    }

    public String getSshUser() {
        return sshUser;
    }

    public void setSshUser(String sshUser) {
        this.sshUser = sshUser;
    }

    public String getSshPassword() {
        return sshPassword;
    }

    public void setSshPassword(String sshPassword) {
        this.sshPassword = sshPassword;
    }

    public String getSshPort() {
        return sshPort;
    }

    public void setSshPort(String sshPort) {
        this.sshPort = sshPort;
    }

    public String getJbossDirectory() {
        return jbossDirectory;
    }

    public void setJbossDirectory(String jbossDirectory) {
        this.jbossDirectory = jbossDirectory;
    }

    public String getRightvSourcesDirectory() {
        return rightvSourcesDirectory;
    }

    public void setRightvSourcesDirectory(String rightvSourcesDirectory) {
        this.rightvSourcesDirectory = rightvSourcesDirectory;
    }
}