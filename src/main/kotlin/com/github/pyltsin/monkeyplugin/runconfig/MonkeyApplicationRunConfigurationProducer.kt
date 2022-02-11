package com.github.pyltsin.monkeyplugin.runconfig

import com.intellij.execution.actions.ConfigurationContext
import com.intellij.execution.actions.RunConfigurationProducer
import com.intellij.openapi.util.Ref
import com.intellij.psi.PsiElement
import java.io.File

class MonkeyApplicationRunConfigurationProducer :
    RunConfigurationProducer<MonkeyRunConfiguration>(MonkeyRunConfigurationType.getInstance()) {

    override fun isConfigurationFromContext(
        configuration: MonkeyRunConfiguration,
        context: ConfigurationContext
    ): Boolean {
        return configuration.pathToFile == context.psiLocation?.getPath()
    }

    override fun setupConfigurationFromContext(
        configuration: MonkeyRunConfiguration,
        context: ConfigurationContext,
        sourceElement: Ref<PsiElement>
    ): Boolean {
        val element = sourceElement.get()
        configuration.pathToFile = element.getPath()
        return true
    }

    private fun PsiElement.getPath() =
        this.containingFile.containingDirectory.virtualFile.presentableUrl + File.separatorChar.toString() + this.containingFile.name
}
