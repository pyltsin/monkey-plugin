package com.github.pyltsin.monkeyplugin.runconfig

import com.intellij.execution.actions.ConfigurationContext
import com.intellij.execution.actions.RunConfigurationProducer
import com.intellij.openapi.util.Ref
import com.intellij.psi.PsiElement

class MonkeyApplicationRunConfigurationProducer :
    RunConfigurationProducer<MonkeyRunConfiguration>(MonkeyRunConfigurationType.getInstance()) {

    override fun isConfigurationFromContext(
        configuration: MonkeyRunConfiguration,
        context: ConfigurationContext
    ): Boolean {
        return true
    }

    override fun setupConfigurationFromContext(
        configuration: MonkeyRunConfiguration,
        context: ConfigurationContext,
        sourceElement: Ref<PsiElement>
    ): Boolean {
        return true
    }
}
