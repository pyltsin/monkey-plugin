package com.github.pyltsin.monkeyplugin.psi.impl

import com.github.pyltsin.monkeyplugin.MonkeyLanguage
import com.github.pyltsin.monkeyplugin.psi.MonkeyFile
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory

class MonkeyElementTextFactory {
    companion object{
        fun createStatementFromText(project: Project, name: String): PsiElement {
            val fileFromText: MonkeyFile =
                createFileFromText(project, name)
            return fileFromText.firstChild.firstChild
        }

        fun createFileFromText(project: Project, text: String): MonkeyFile {
            return PsiFileFactory.getInstance(project)
                .createFileFromText("A.monkey", MonkeyLanguage.INSTANCE, text) as MonkeyFile
        }
    }
}
