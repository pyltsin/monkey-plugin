package com.github.pyltsin.monkeyplugin.services

import com.intellij.openapi.project.Project
import com.github.pyltsin.monkeyplugin.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
