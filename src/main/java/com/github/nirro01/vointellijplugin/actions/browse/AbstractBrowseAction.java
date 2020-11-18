package com.github.nirro01.vointellijplugin.actions.browse;

import com.intellij.ide.BrowserUtil;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.project.DumbAware;
import org.jetbrains.annotations.NotNull;

public class AbstractBrowseAction extends AnAction implements DumbAware {

    private String url;

    public AbstractBrowseAction(String url) {
        this.url = url;
    }

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        BrowserUtil.browse(url);
    }
}
