package com.github.nirro01.vointellijplugin.settings;

import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class AppSettingsComponent {
    private final JPanel myMainPanel;
    private final JBTextField sshHostText = new JBTextField();
    private final JBTextField sshUserText = new JBTextField();
    private final JBTextField sshPasswordText = new JBTextField();
    private final JBTextField sshPortText = new JBTextField();
    private final JBTextField jbossDirectoryText = new JBTextField();

    public static final String SSH_HOST_LABEL = "Rightv SSH Host: ";
    public static final String SSH_USER_LABEL = "Rightv SSH User: ";
    public static final String SSH_PASSWORD_LABEL = "Rightv SSH Password: ";
    public static final String SSH_PORT_LABEL = "Rightv SSH Port: ";
    public static final String JBOSS_DIRECTORY_LABEL = "JBoss directory: ";


    public AppSettingsComponent() {
        myMainPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(new JBLabel(SSH_HOST_LABEL), sshHostText, 1, false)
                .addLabeledComponent(new JBLabel(SSH_USER_LABEL), sshUserText, 1, false)
                .addLabeledComponent(new JBLabel(SSH_PASSWORD_LABEL), sshPasswordText, 1, false)
                .addLabeledComponent(new JBLabel(SSH_PORT_LABEL), sshPortText, 1, false)
                .addSeparator()
                .addLabeledComponent(new JBLabel(JBOSS_DIRECTORY_LABEL), jbossDirectoryText, 1, false)

                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();
    }

    public JPanel getPanel() {
        return myMainPanel;
    }

    public JComponent getPreferredFocusedComponent() {
        return sshUserText;
    }
    @NotNull
    public String getSshHostText() {
        return sshHostText.getText();
    }

    public void setSshHostText(@NotNull String newText) {
        sshHostText.setText(newText);
    }
    @NotNull
    public String getSshUserText() {
        return sshUserText.getText();
    }

    public void setSshUserText(@NotNull String newText) {
        sshUserText.setText(newText);
    }

    @NotNull
    public String getSshPasswordText() {
        return sshPasswordText.getText();
    }
    public void setSshPasswordText(@NotNull String newText) {
        sshPasswordText.setText(newText);
    }

    @NotNull
    public String getSshPortText() {
        return sshPortText.getText();
    }

    public void setSshPortText(@NotNull String newText) {
        sshPortText.setText(newText);
    }
    @NotNull
    public String getJbossDirectoryText() {
        return jbossDirectoryText.getText();
    }

    public void setJbossDirectoryText(@NotNull String newText) {
        jbossDirectoryText.setText(newText);
    }
}
