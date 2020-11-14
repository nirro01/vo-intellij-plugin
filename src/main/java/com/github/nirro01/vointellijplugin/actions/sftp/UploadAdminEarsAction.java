package com.github.nirro01.vointellijplugin.actions.sftp;

import com.github.nirro01.vointellijplugin.settings.AppSettingsState;
import com.intellij.openapi.util.Pair;

import java.util.Arrays;
import java.util.List;

import static java.nio.file.Paths.get;

public class UploadAdminEarsAction extends AbstractSFTPAction {

    @Override
    String getTitle() {
        return "Upload Admin Ears";
    }

    @Override
    List<Pair<String, String>> getFilesAndDestinationPairList() {

        return Arrays.asList(
                //translator.ear
                Pair.create(get(AppSettingsState.getInstance().getRightvSourcesDirectory(), "admin", "translator", "translator-ear", "target", "translator.ear").toString(),
                        AppSettingsState.getInstance().getJbossDirectory() + "/admin-RIGHTV/deployments/translator.ear"),

                //JobScheduler.ear
                Pair.create(get(AppSettingsState.getInstance().getRightvSourcesDirectory(), "admin", "job-scheduler", "job-scheduler-ear", "target", "JobScheduler.ear").toString(),
                        AppSettingsState.getInstance().getJbossDirectory() + "/admin-RIGHTV/deployments/JobScheduler.ear"),

                //EPGUpload.ear
                Pair.create(get(AppSettingsState.getInstance().getRightvSourcesDirectory(), "admin", "epg-upload", "epg-upload-ear", "target", "EPGUpload.ear").toString(),
                        AppSettingsState.getInstance().getJbossDirectory() + "/admin-RIGHTV/deployments/EPGUpload.ear"),

                //AssetIngestion.ear
                Pair.create(get(AppSettingsState.getInstance().getRightvSourcesDirectory(), "admin", "asset-ingestion", "asset-ingestion-ear", "target", "AssetIngestion.ear").toString(),
                        AppSettingsState.getInstance().getJbossDirectory() + "/admin-RIGHTV/deployments/AssetIngestion.ear"),

                //adminapi.ear
                Pair.create(get(AppSettingsState.getInstance().getRightvSourcesDirectory(), "admin", "admin-api", "ear", "target", "adminapi.ear").toString(),
                        AppSettingsState.getInstance().getJbossDirectory() + "/admin-RIGHTV/deployments/adminapi.ear")
        );
    }
}
