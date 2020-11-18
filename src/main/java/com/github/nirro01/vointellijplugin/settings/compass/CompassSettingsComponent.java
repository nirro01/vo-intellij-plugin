package com.github.nirro01.vointellijplugin.settings.compass;

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.ui.TextBrowseFolderListener;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class CompassSettingsComponent {
    public static final String SSH_HOST_LABEL = "Compass SSH Host: ";
    public static final String SSH_USER_LABEL = "Compass SSH User: ";
    public static final String SSH_PASSWORD_LABEL = "Compass SSH Password: ";
    public static final String SSH_PORT_LABEL = "Compass SSH Port: ";
    public static final String JBOSS_DIRECTORY_LABEL = "Remote JBoss directory: ";
    public static final String LOCAL_COMPASS_SOURCES_DIRECTORY_LABEL = "Local Compass \"polo-3.1-dev\" directory: ";
    private static final String TEXT_1 = "<html>This user is used for file transfer and JBoss actions</html>";
    private static final String TEXT_2 = "<html>In most servers the path is <b><i>/export/home/compass/compass/jboss</i></b></html>";
    private static final String TEXT_3 = "<html>It should be similar to <b><i>C:\\repo\\compass\\polo-3.1-dev</i></b></html>";
    private final JPanel myMainPanel;
    private JBTextField sshHostText;
    private JBTextField sshUserText;
    private JBTextField sshPasswordText;
    private JBTextField sshPortText;
    private JBTextField jbossDirectoryText;
    private TextFieldWithBrowseButton localCompassPolo1DevDirectoryText;

    public CompassSettingsComponent() {
        initPanel();
        myMainPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(new JBLabel(SSH_HOST_LABEL), sshHostText, 1, false)
                .addLabeledComponent(new JBLabel(SSH_USER_LABEL), sshUserText, 1, false)
                .addLabeledComponent(new JBLabel(SSH_PASSWORD_LABEL), sshPasswordText, 1, false)
                .addLabeledComponent(new JBLabel(SSH_PORT_LABEL), sshPortText, 1, false)
                .addLabeledComponent(new JBLabel(), new JBLabel(TEXT_1), 1, false)
                .addSeparator()
                .addLabeledComponent(new JBLabel(JBOSS_DIRECTORY_LABEL), jbossDirectoryText, 1, false)
                .addLabeledComponent(new JBLabel(), new JBLabel(TEXT_2), 1, false)
                .addLabeledComponent(new JBLabel(LOCAL_COMPASS_SOURCES_DIRECTORY_LABEL), localCompassPolo1DevDirectoryText, 1, false)
                .addLabeledComponent(new JBLabel(), new JBLabel(TEXT_3), 1, false)
                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();
        localCompassPolo1DevDirectoryText.addBrowseFolderListener((new TextBrowseFolderListener(FileChooserDescriptorFactory.createSingleFolderDescriptor())));
    }

    private void initPanel() {
        sshHostText = new JBTextField();
        sshUserText = new JBTextField();
        sshPasswordText = new JBTextField();
        sshPortText = new JBTextField();
        jbossDirectoryText = new JBTextField();
        localCompassPolo1DevDirectoryText = new TextFieldWithBrowseButton();
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

    @NotNull
    public String getLocalCompassPolo1DevDirectoryText() {
        return localCompassPolo1DevDirectoryText.getText();
    }

    public void setLocalCompassPolo1DevDirectoryText(@NotNull String newText) {
        localCompassPolo1DevDirectoryText.setText(newText);
    }
}
