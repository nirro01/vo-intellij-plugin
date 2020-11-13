package com.github.nirro01.vointellijplugin.actions.rte;

import com.github.nirro01.vointellijplugin.services.MyApplicationService;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.components.ServiceManager;
import org.jetbrains.annotations.NotNull;

public class RestartRTEAction extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        MyApplicationService service = ServiceManager.getService(MyApplicationService.class);
        service.restartRTE(e.getProject());
    }

}
