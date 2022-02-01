package com.github.pyltsin.monkeyplugin.runconfig

import com.github.pyltsin.monkeyplugin.MonkeyIcons
import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.ConfigurationType
import com.intellij.execution.configurations.ConfigurationTypeBase
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.openapi.extensions.Extensions
import com.intellij.openapi.project.Project

class MonkeyRunConfigurationType :
    ConfigurationTypeBase(
        "MonkeyRunConfigurationType",
        "Monkey Application",
        "Monkey application run configuration",
        MonkeyIcons.FILE
    ) {
    init {
        addFactory(MonkeyFactory(this))
    }

    companion object {
        @JvmStatic
        fun getInstance(): MonkeyRunConfigurationType {
            return Extensions.findExtension(
                ConfigurationType.CONFIGURATION_TYPE_EP,
                MonkeyRunConfigurationType::class.java)
        }
    }
}

class MonkeyFactory(type: ConfigurationType) : ConfigurationFactory(type) {
    override fun getId(): String {
        return "Monkey"
    }

    override fun createTemplateConfiguration(project: Project): RunConfiguration {
        return MonkeyRunConfiguration(
            project,
            "Monkey",
            MonkeyRunConfigurationType.getInstance()
        )
    }
}
