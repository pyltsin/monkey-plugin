package com.github.pyltsin.monkeyplugin.runconfig

import com.github.pyltsin.monkeyplugin.MonkeyLanguage
import com.github.pyltsin.monkeyplugin.psi.MonkeyAll
import com.github.pyltsin.monkeyplugin.psi.MonkeyExpr
import com.intellij.execution.lineMarker.ExecutorAction
import com.intellij.execution.lineMarker.RunLineMarkerContributor
import com.intellij.icons.AllIcons
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.psi.PsiElement
import com.intellij.psi.impl.source.tree.LeafPsiElement

class MonkeyRunLineMarkerContributor : RunLineMarkerContributor() {
    override fun getInfo(element: PsiElement): Info? {
        if (element.language != MonkeyLanguage.INSTANCE) {
            return null
        }

        if (!element.isValid) {
            return null
        }

        if (element !is LeafPsiElement) {
            return null
        }

        if (element.children.isNotEmpty() || element is MonkeyExpr) {
            return null
        }

        var currentElement: PsiElement? = element
        while (true) {
            if (currentElement == null || currentElement is MonkeyAll) {
                break
            }
            if (currentElement.prevSibling != null) {
                return null
            }
            currentElement = currentElement.parent
        }

        val action: AnAction = ExecutorAction.getActions(0)[0]

        return Info(AllIcons.RunConfigurations.TestState.Run, arrayListOf(action).toTypedArray()) { "Run" }
    }
}
