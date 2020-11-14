package com.github.nirro01.vointellijplugin.settings;

import com.intellij.openapi.options.Configurable;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Objects;

public class AppSettingsConfigurable implements Configurable {

    private AppSettingsComponent mySettingsComponent;

    // A default constructor with no arguments is required because this implementation
    // is registered as an applicationConfigurable EP

    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return "VO Devtools";
    }

    @Override
    public JComponent getPreferredFocusedComponent() {
        return mySettingsComponent.getPreferredFocusedComponent();
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        mySettingsComponent = new AppSettingsComponent();
        return mySettingsComponent.getPanel();
    }

    @Override
    public boolean isModified() {
        AppSettingsState settings = AppSettingsState.getInstance();
        return !(Objects.equals(mySettingsComponent.getSshHostText(), settings.sshHost) &&
                Objects.equals(mySettingsComponent.getSshUserText(), settings.sshUser) &&
                Objects.equals(mySettingsComponent.getSshPasswordText(), settings.sshPassword) &&
                Objects.equals(mySettingsComponent.getSshPortText(), settings.sshPort) &&
                Objects.equals(mySettingsComponent.getJbossDirectoryText(), settings.jbossDirectory)
        );

    }

    @Override
    public void apply() {
        AppSettingsState settings = AppSettingsState.getInstance();
        settings.sshHost = mySettingsComponent.getSshHostText();
        settings.sshUser = mySettingsComponent.getSshUserText();
        settings.sshPassword = mySettingsComponent.getSshPasswordText();
        settings.sshPort = mySettingsComponent.getSshPortText();
        settings.jbossDirectory = mySettingsComponent.getJbossDirectoryText();
    }

    @Override
    public void reset() {
        AppSettingsState settings = AppSettingsState.getInstance();
        mySettingsComponent.setSshHostText(settings.sshHost);
        mySettingsComponent.setSshUserText(settings.sshUser);
        mySettingsComponent.setSshPasswordText(settings.sshPassword);
        mySettingsComponent.setSshPortText(settings.sshPort);
        mySettingsComponent.setJbossDirectoryText(settings.jbossDirectory);
    }

    @Override
    public void disposeUIResources() {
        mySettingsComponent = null;
    }

}
