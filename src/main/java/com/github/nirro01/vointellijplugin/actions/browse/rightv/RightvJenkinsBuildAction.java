package com.github.nirro01.vointellijplugin.actions.browse.rightv;

import com.github.nirro01.vointellijplugin.actions.browse.AbstractBrowseAction;

import static com.github.nirro01.vointellijplugin.actions.browse.Constants.RIGHTV_JENKINS_BUILD;

public class RightvJenkinsBuildAction extends AbstractBrowseAction {

    @Override
    public String getUrl() {
        return RIGHTV_JENKINS_BUILD;
    }
}
