package com.github.nirro01.vointellijplugin.actions.browse;

import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.DumbAware;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractBrowseAction extends AnAction implements DumbAware {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        BrowserUtil.browse(getUrl());
    }

    public abstract String getUrl();
}
