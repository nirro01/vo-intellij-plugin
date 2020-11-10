package com.github.nirro01.vointellijplugin.services

import com.intellij.openapi.project.Project
import com.github.nirro01.vointellijplugin.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
