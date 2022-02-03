package com.github.pyltsin.monkeyplugin.annotator

import com.github.pyltsin.monkeyplugin.psi.MonkeyAll
import com.github.pyltsin.monkeyplugin.psi.MonkeyLetStatement
import com.github.pyltsin.monkeyplugin.psi.MonkeySimpleRefExpr
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.psi.PsiElement

class MonkeyGlobalDefinitionAnnotator: Annotator {
    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element !is MonkeySimpleRefExpr) {
            return
        }
        val parent = element.parent
        if (parent !is MonkeyLetStatement) {
            return
        }
        val grandParent = parent.parent
        if (grandParent !is MonkeyAll) {
            return
        }
        holder.newSilentAnnotation(HighlightSeverity.INFORMATION)
            .range(element)
            .textAttributes(DefaultLanguageHighlighterColors.GLOBAL_VARIABLE)
            .create()
    }
}
