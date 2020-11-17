package com.github.nirro01.vointellijplugin.actions.sftp;

import com.github.nirro01.vointellijplugin.settings.rightv.RightvSettingsState;
import com.intellij.openapi.util.Pair;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.Paths.get;

public class UploadJBossModulesAction extends AbstractSFTPAction {

    @Override
    public String getProgressBarTitle() {
        return "JBoss modules jars";
    }

    @Override
    List<Pair<String, String>> filesAndDestinationDefinition() {

        try {
            return Files.list(get(RightvSettingsState.getInstance().getRightvSourcesDirectory(), "jboss-preparation", "target", "modules-jars"))
                    .filter(Files::isRegularFile)
                    .sorted()
                    .map(file -> Pair.create(file.toString(), RightvSettingsState.getInstance().getJbossDirectory() + "/modules/com/orca/common/main/" + file.getFileName().toString()))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
