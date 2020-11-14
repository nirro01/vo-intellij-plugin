package com.github.nirro01.vointellijplugin.settings;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Objects;

import static com.github.nirro01.vointellijplugin.settings.AppSettingsComponent.*;

public class AppSettingsConfigurable implements Configurable {

    private AppSettingsComponent mySettingsComponent;


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
        return !(Objects.equals(mySettingsComponent.getSshHostText(), settings.getSshHost()) &&
                Objects.equals(mySettingsComponent.getSshUserText(), settings.getSshUser()) &&
                Objects.equals(mySettingsComponent.getSshPasswordText(), settings.getSshPassword()) &&
                Objects.equals(mySettingsComponent.getSshPortText(), settings.getSshPort()) &&
                Objects.equals(mySettingsComponent.getJbossDirectoryText(), settings.getJbossDirectory()) &&
                Objects.equals(mySettingsComponent.getLocalRightvSourcesDirectoryText(), settings.getRightvSourcesDirectory())
        );

    }

    @Override
    public void apply() throws ConfigurationException {
        validateSettings();
        AppSettingsState settings = AppSettingsState.getInstance();
        settings.setSshHost(mySettingsComponent.getSshHostText());
        settings.setSshUser(mySettingsComponent.getSshUserText());
        settings.setSshPassword(mySettingsComponent.getSshPasswordText());
        settings.setSshPort(mySettingsComponent.getSshPortText());
        settings.setJbossDirectory(mySettingsComponent.getJbossDirectoryText());
        settings.setRightvSourcesDirectory(mySettingsComponent.getLocalRightvSourcesDirectoryText());
    }

    private void validateSettings() throws ConfigurationException {
        validateNotEmpty(mySettingsComponent.getSshHostText(), SSH_HOST_LABEL);
        validateNotEmpty(mySettingsComponent.getSshUserText(), SSH_USER_LABEL);
        validateNotEmpty(mySettingsComponent.getSshPasswordText(), SSH_PASSWORD_LABEL);
        validateNotEmpty(mySettingsComponent.getSshPortText(), SSH_PORT_LABEL);
        validateNumber(mySettingsComponent.getSshPortText(), SSH_PORT_LABEL);
        validateNotEmpty(mySettingsComponent.getJbossDirectoryText(), JBOSS_DIRECTORY_LABEL);
        validateNotEmpty(mySettingsComponent.getLocalRightvSourcesDirectoryText(), LOCAL_RIGHTV_SOURCES_DIRECTORY_LABEL);
        validateEndsWithSources(mySettingsComponent.getLocalRightvSourcesDirectoryText(), LOCAL_RIGHTV_SOURCES_DIRECTORY_LABEL);
    }

    private void validateEndsWithSources(String text, String label) throws ConfigurationException {
        if (!text.trim().endsWith("sources")) {
            throw new ConfigurationException(label + " is not a \"sources\" folder");
        }
    }

    private void validateNumber(String text, String label) throws ConfigurationException {
        try {
            Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new ConfigurationException(label + " is not a number");
        }
    }

    private void validateNotEmpty(String text, String label) throws ConfigurationException {
        if (text.trim().isEmpty()) {
            throw new ConfigurationException(label + " cannot be empty");
        }
    }

    @Override
    public void reset() {
        AppSettingsState settings = AppSettingsState.getInstance();
        mySettingsComponent.setSshHostText(settings.getSshHost());
        mySettingsComponent.setSshUserText(settings.getSshUser());
        mySettingsComponent.setSshPasswordText(settings.getSshPassword());
        mySettingsComponent.setSshPortText(settings.getSshPort());
        mySettingsComponent.setJbossDirectoryText(settings.getJbossDirectory());
        mySettingsComponent.setLocalRightvSourcesDirectoryText(settings.getRightvSourcesDirectory());
    }

    @Override
    public void disposeUIResources() {
        mySettingsComponent = null;
    }

}
