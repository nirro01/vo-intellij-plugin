package com.github.nirro01.vointellijplugin.actions.browse;

import static com.github.nirro01.vointellijplugin.actions.browse.Constants.DEPLOY_TEMPORARY_NAMESPACE;

public class DeployTemporaryNamespaceAction extends AbstractBrowseAction {

    @Override
    public String getUrl() {
        return DEPLOY_TEMPORARY_NAMESPACE;
    }
}
