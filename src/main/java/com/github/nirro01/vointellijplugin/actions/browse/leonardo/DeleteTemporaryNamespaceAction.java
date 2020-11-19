package com.github.nirro01.vointellijplugin.actions.browse.leonardo;

import com.github.nirro01.vointellijplugin.actions.browse.AbstractBrowseAction;

import static com.github.nirro01.vointellijplugin.actions.browse.Constants.DELETE_TEMPORARY_NAMESPACE;

public class DeleteTemporaryNamespaceAction extends AbstractBrowseAction {

    @Override
    public String getUrl() {
        return DELETE_TEMPORARY_NAMESPACE;
    }
}
