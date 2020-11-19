package com.github.nirro01.vointellijplugin.actions.browse.leonardo;

import com.github.nirro01.vointellijplugin.actions.browse.AbstractBrowseAction;

import static com.github.nirro01.vointellijplugin.actions.browse.Constants.LEONARDO_LINKS;

public class LeonardoLinksAction extends AbstractBrowseAction {

    @Override
    public String getUrl() {
        return LEONARDO_LINKS;
    }
}
