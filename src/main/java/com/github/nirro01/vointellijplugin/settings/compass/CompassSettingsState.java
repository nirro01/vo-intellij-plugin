package com.github.nirro01.vointellijplugin.settings.compass;

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
        name = "org.intellij.sdk.settings.compass.CompassSettingsState",
        storages = {@Storage("SdkSettingsPlugin.xml")}
)
public class CompassSettingsState implements PersistentStateComponent<CompassSettingsState> {

    private String sshHost = "xxx.xxx.xxx.xxx";
    private String sshUser = "compass";
    private String sshPassword = "compass";
    private String sshPort = "22";
    private String jbossDirectory = "/home/compass/jboss";
    private String compassSourcesDirectory = "C:\\compass\\sources";

    public static CompassSettingsState getInstance() {
        return ServiceManager.getService(CompassSettingsState.class);
    }

    @Nullable
    @Override
    public CompassSettingsState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull CompassSettingsState state) {
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

    public String getCompassSourcesDirectory() {
        return compassSourcesDirectory;
    }

    public void setCompassSourcesDirectory(String compassSourcesDirectory) {
        this.compassSourcesDirectory = compassSourcesDirectory;
    }
}