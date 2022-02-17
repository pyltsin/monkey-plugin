package com.github.pyltsin.monkeyplugin.refactor

import com.github.pyltsin.monkeyplugin.psi.MonkeyNamedElement
import com.github.pyltsin.monkeyplugin.psi.MonkeySimpleRefExpr
import com.intellij.patterns.ElementPattern
import com.intellij.patterns.ElementPatternCondition
import com.intellij.patterns.InitialPatternCondition
import com.intellij.psi.PsiElement
import com.intellij.refactoring.rename.RenameInputValidator
import com.intellij.util.ProcessingContext

val regex = Regex("[a-zA-Z]+")

class MonkeyRenameInputValidator : RenameInputValidator {
    private val pattern = object : ElementPattern<PsiElement> {
        private val condition =
            ElementPatternCondition(object : InitialPatternCondition<PsiElement>(PsiElement::class.java) {
                override fun accepts(o: Any?, context: ProcessingContext?) = false
            })

        override fun accepts(o: Any?): Boolean = o is MonkeyNamedElement || o is MonkeySimpleRefExpr

        override fun accepts(o: Any?, context: ProcessingContext?): Boolean = accepts(o)

        override fun getCondition(): ElementPatternCondition<PsiElement> = condition
    }

    override fun getPattern(): ElementPattern<out PsiElement> = pattern

    override fun isInputValid(newName: String, element: PsiElement, context: ProcessingContext): Boolean {
        return regex.matches(newName)
    }
}
