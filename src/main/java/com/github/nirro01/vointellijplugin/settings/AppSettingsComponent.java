package com.github.nirro01.vointellijplugin.settings;

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.ui.TextBrowseFolderListener;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class AppSettingsComponent {
    private final JPanel myMainPanel;
    private JBTextField sshHostText;
    private JBTextField sshUserText;
    private JBTextField sshPasswordText;
    private JBTextField sshPortText;
    private JBTextField jbossDirectoryText;
    private TextFieldWithBrowseButton localRightvSourcesDirectoryText;

    public static final String SSH_HOST_LABEL = "Rightv SSH Host: ";
    public static final String SSH_USER_LABEL = "Rightv SSH User: ";
    public static final String SSH_PASSWORD_LABEL = "Rightv SSH Password: ";
    public static final String SSH_PORT_LABEL = "Rightv SSH Port: ";
    public static final String JBOSS_DIRECTORY_LABEL = "Remote JBoss directory: ";
    public static final String LOCAL_RIGHTV_SOURCES_DIRECTORY_LABEL = "Local Rightv \"sources\" directory: ";

    private static final String text1 = "<html>This user is used for file transfer and JBoss actions</html>";
    private static final String text2 = "<html>In most servers the path is <b><i>/export/home/rightv/jboss</i></b> <br>Another option is <b><i>/home/rightv/jboss</i></b></html>";
    private static final String text3 = "<html>It should be similar to <b><i>C:\\repo\\rightv\\sources</i></b></html>";

    public AppSettingsComponent() {
        initPanel();
        myMainPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(new JBLabel(SSH_HOST_LABEL), sshHostText, 1, false)
                .addLabeledComponent(new JBLabel(SSH_USER_LABEL), sshUserText, 1, false)
                .addLabeledComponent(new JBLabel(SSH_PASSWORD_LABEL), sshPasswordText, 1, false)
                .addLabeledComponent(new JBLabel(SSH_PORT_LABEL), sshPortText, 1, false)
                .addLabeledComponent(new JBLabel(), new JBLabel(text1), 1, false)
                .addSeparator()
                .addLabeledComponent(new JBLabel(JBOSS_DIRECTORY_LABEL), jbossDirectoryText, 1, false)
                .addLabeledComponent(new JBLabel(), new JBLabel(text2), 1, false)
                .addLabeledComponent(new JBLabel(LOCAL_RIGHTV_SOURCES_DIRECTORY_LABEL), localRightvSourcesDirectoryText, 1, false)
                .addLabeledComponent(new JBLabel(), new JBLabel(text3), 1, false)
                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();
        localRightvSourcesDirectoryText.addBrowseFolderListener((new TextBrowseFolderListener(FileChooserDescriptorFactory.createSingleFolderDescriptor())));
    }

    private void initPanel() {
        sshHostText = new JBTextField();
        sshUserText = new JBTextField();
        sshPasswordText = new JBTextField();
        sshPortText = new JBTextField();
        jbossDirectoryText = new JBTextField();
        localRightvSourcesDirectoryText = new TextFieldWithBrowseButton();
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
    public String getLocalRightvSourcesDirectoryText() {
        return localRightvSourcesDirectoryText.getText();
    }

    public void setLocalRightvSourcesDirectoryText(@NotNull String newText) {
        localRightvSourcesDirectoryText.setText(newText);
    }
}
