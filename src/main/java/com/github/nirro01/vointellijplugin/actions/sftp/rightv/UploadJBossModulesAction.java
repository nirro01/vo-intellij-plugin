package com.github.nirro01.vointellijplugin.actions.sftp.rightv;

import com.github.nirro01.vointellijplugin.settings.rightv.RightvSettingsState;
import com.intellij.openapi.util.Pair;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.nio.file.Paths.get;

public class UploadJBossModulesAction extends AbstractRightvSFTPAction {

    @Override
    public String progressBarTitle() {
        return "JBoss modules jars";
    }


    public List<Pair<String, String>> filesAndDestinationDefinition() {
        try (Stream<Path> pathStream = Files.list(get(RightvSettingsState.getInstance().getRightvSourcesDirectory(), "jboss-preparation", "target", "modules-jars"))) {
            return pathStream.filter(Files::isRegularFile)
                    .sorted()
                    .map(file -> Pair.create(file.toString(), RightvSettingsState.getInstance().getJbossDirectory() + "/modules/com/orca/common/main/" + file.getFileName().toString()))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
