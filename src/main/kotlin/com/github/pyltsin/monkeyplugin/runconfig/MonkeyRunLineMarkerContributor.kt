package com.github.pyltsin.monkeyplugin.runconfig

import com.github.pyltsin.monkeyplugin.MonkeyLanguage
import com.github.pyltsin.monkeyplugin.psi.MonkeyAll
import com.intellij.execution.lineMarker.ExecutorAction
import com.intellij.execution.lineMarker.RunLineMarkerContributor
import com.intellij.icons.AllIcons
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.psi.PsiElement

class MonkeyRunLineMarkerContributor : RunLineMarkerContributor() {
    override fun getInfo(element: PsiElement): Info? {
        if (element.language != MonkeyLanguage.INSTANCE) {
            return null
        }
        if (element !is MonkeyAll) {
            return null
        }

        val actions: Array<AnAction> = ExecutorAction.getActions()

        return Info(AllIcons.RunConfigurations.TestState.Run, actions) { "Run all" }
    }
}
