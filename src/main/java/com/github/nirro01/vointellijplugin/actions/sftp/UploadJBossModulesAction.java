package com.github.nirro01.vointellijplugin.actions.sftp;

import com.github.nirro01.vointellijplugin.settings.AppSettingsState;
import com.intellij.openapi.util.Pair;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.Paths.get;

public class UploadJBossModulesAction extends AbstractSFTPAction {

    @Override
    String getTitle() {
        return "JBoss modules jars";
    }

    @Override
    List<Pair<String, String>> getFilesAndDestinationPairList() {

        try {
            return Files.list(get(AppSettingsState.getInstance().getRightvSourcesDirectory(), "jboss-preparation", "target", "modules-jars"))
                    .filter(Files::isRegularFile)
                    .sorted()
                    .map(file -> Pair.create(file.toString(), AppSettingsState.getInstance().getJbossDirectory() + "/modules/com/orca/common/main/" + file.getFileName().toString()))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
