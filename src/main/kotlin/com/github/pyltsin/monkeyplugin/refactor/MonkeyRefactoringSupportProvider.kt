package com.github.pyltsin.monkeyplugin.refactor

import com.github.pyltsin.monkeyplugin.psi.MonkeyNamedElement
import com.intellij.lang.refactoring.RefactoringSupportProvider
import com.intellij.psi.PsiElement

class MonkeyRefactoringSupportProvider : RefactoringSupportProvider() {
    override fun isMemberInplaceRenameAvailable(element: PsiElement, context: PsiElement?): Boolean =
        element is MonkeyNamedElement
}
