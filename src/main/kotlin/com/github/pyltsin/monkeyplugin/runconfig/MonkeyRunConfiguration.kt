package com.github.pyltsin.monkeyplugin.runconfig

import com.intellij.execution.ExecutionBundle
import com.intellij.execution.Executor
import com.intellij.execution.configuration.AbstractRunConfiguration
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.execution.configurations.RunProfileState
import com.intellij.execution.configurations.RuntimeConfigurationError
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleManager
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project

class MonkeyRunConfiguration(
    project: Project,
    name: String,
    configurationType: MonkeyRunConfigurationType
) :
    AbstractRunConfiguration(project, configurationType.configurationFactories[0]) {
    var pathToGo: String = ""
    var pathToFile: String = ""

    override fun getState(executor: Executor, environment: ExecutionEnvironment): RunProfileState? {
        return MonkeyApplicationCommandLineState(environment, this)
    }

    override fun getConfigurationEditor(): SettingsEditor<out RunConfiguration> {
        return MonkeyRunConfigurationEditorForm()
    }

    override fun checkSettingsBeforeRun() {
        if (pathToFile.isBlank() || pathToGo.isBlank()) {
            throw RuntimeConfigurationError("Empty settings")
        }
    }

    override fun getValidModules(): MutableCollection<Module> {
        val modules = ModuleManager.getInstance(project).modules
        return mutableListOf(*modules)
    }
}
