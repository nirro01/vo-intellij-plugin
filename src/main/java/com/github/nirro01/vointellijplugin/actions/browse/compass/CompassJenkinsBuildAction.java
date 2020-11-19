package com.github.nirro01.vointellijplugin.actions.browse.compass;

import com.github.nirro01.vointellijplugin.actions.browse.AbstractBrowseAction;

import static com.github.nirro01.vointellijplugin.actions.browse.Constants.COMPASS_JENKINS_BUILD;

public class CompassJenkinsBuildAction extends AbstractBrowseAction {

    @Override
    public String getUrl() {
        return COMPASS_JENKINS_BUILD;
    }
}
