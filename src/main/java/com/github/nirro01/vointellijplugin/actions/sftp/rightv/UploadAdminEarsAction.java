package com.github.nirro01.vointellijplugin.actions.sftp.rightv;

import com.github.nirro01.vointellijplugin.settings.rightv.RightvSettingsState;
import com.intellij.openapi.util.Pair;

import java.util.Arrays;
import java.util.List;

import static java.nio.file.Paths.get;

public class UploadAdminEarsAction extends AbstractRightvSFTPAction {

    @Override
    public String progressBarTitle() {
        return "Upload Admin Ears";
    }


    public List<Pair<String, String>> filesAndDestinationDefinition() {

        return Arrays.asList(
                //translator.ear
                Pair.create(get(RightvSettingsState.getInstance().getRightvSourcesDirectory(), "admin", "translator", "translator-ear", "target", "translator.ear").toString(),
                        RightvSettingsState.getInstance().getJbossDirectory() + "/admin-RIGHTV/deployments/translator.ear"),

                //JobScheduler.ear
                Pair.create(get(RightvSettingsState.getInstance().getRightvSourcesDirectory(), "admin", "job-scheduler", "job-scheduler-ear", "target", "JobScheduler.ear").toString(),
                        RightvSettingsState.getInstance().getJbossDirectory() + "/admin-RIGHTV/deployments/JobScheduler.ear"),

                //EPGUpload.ear
                Pair.create(get(RightvSettingsState.getInstance().getRightvSourcesDirectory(), "admin", "epg-upload", "epg-upload-ear", "target", "EPGUpload.ear").toString(),
                        RightvSettingsState.getInstance().getJbossDirectory() + "/admin-RIGHTV/deployments/EPGUpload.ear"),

                //AssetIngestion.ear
                Pair.create(get(RightvSettingsState.getInstance().getRightvSourcesDirectory(), "admin", "asset-ingestion", "asset-ingestion-ear", "target", "AssetIngestion.ear").toString(),
                        RightvSettingsState.getInstance().getJbossDirectory() + "/admin-RIGHTV/deployments/AssetIngestion.ear"),

                //adminapi.ear
                Pair.create(get(RightvSettingsState.getInstance().getRightvSourcesDirectory(), "admin", "admin-api", "ear", "target", "adminapi.ear").toString(),
                        RightvSettingsState.getInstance().getJbossDirectory() + "/admin-RIGHTV/deployments/adminapi.ear")
        );
    }
}
