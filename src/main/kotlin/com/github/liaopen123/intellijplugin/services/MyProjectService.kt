package com.github.liaopen123.intellijplugin.services

import com.github.liaopen123.intellijplugin.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
