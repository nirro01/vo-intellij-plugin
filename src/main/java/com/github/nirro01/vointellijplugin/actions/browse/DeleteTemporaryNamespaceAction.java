package com.github.nirro01.vointellijplugin.actions.browse;

import static com.github.nirro01.vointellijplugin.actions.browse.Constants.DELETE_TEMPORARY_NAMESPACE;

public class DeleteTemporaryNamespaceAction extends AbstractBrowseAction {

    @Override
    public String getUrl() {
        return DELETE_TEMPORARY_NAMESPACE;
    }
}
