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
    public AppSettingsComponent() {
        myMainPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(new JBLabel("Rightv SSH Host: "), sshHostText, 1, false)
                .addLabeledComponent(new JBLabel("Rightv SSH User: "), sshUserText, 1, false)
                .addLabeledComponent(new JBLabel("Rightv SSH Password: "), sshPasswordText, 1, false)
                .addLabeledComponent(new JBLabel("Rightv SSH Port: "), sshPortText, 1, false)
                .addSeparator()
                .addLabeledComponent(new JBLabel("JBoss directory: "), jbossDirectoryText, 1, false)

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
