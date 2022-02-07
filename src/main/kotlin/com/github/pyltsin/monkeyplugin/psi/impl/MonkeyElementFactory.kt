package com.github.pyltsin.monkeyplugin.psi.impl

import com.github.pyltsin.monkeyplugin.MonkeyLanguage
import com.github.pyltsin.monkeyplugin.psi.MonkeyFile
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFileFactory

class MonkeyElementFactory {
    companion object{
        fun createExpressionFromText(project: Project, name: String): PsiElement {
            val fileFromText: MonkeyFile =
                createFileFromText(project, name)
            val rhs: PsiElement = fileFromText.firstChild.firstChild.lastChild
            return rhs.lastChild.lastChild.lastChild
        }

        fun createFileFromText(project: Project, text: String): MonkeyFile {
            return PsiFileFactory.getInstance(project)
                .createFileFromText("A.monkey", MonkeyLanguage.INSTANCE, text) as MonkeyFile
        }
    }
}
