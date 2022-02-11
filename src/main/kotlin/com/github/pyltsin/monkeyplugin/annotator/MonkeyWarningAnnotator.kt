package com.github.pyltsin.monkeyplugin.annotator

import com.github.pyltsin.monkeyplugin.psi.MonkeyCallExpr
import com.github.pyltsin.monkeyplugin.psi.MonkeyExpr
import com.github.pyltsin.monkeyplugin.psi.MonkeySimpleRefExpr
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement

class MonkeyWarningAnnotator : Annotator {
    private val builtInFunctionNames = setOf("print")

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (!element.isValid) {
            return
        }

        processReferences(element, holder)
        processTypes(element, holder)
    }

    private fun processTypes(element: PsiElement, holder: AnnotationHolder) {
        if (element !is MonkeyExpr) {
            return
        }
        val resolvedType = element.resolveType()
        if (resolvedType.error != null) {
            holder.newAnnotation(HighlightSeverity.ERROR, resolvedType.error.explanation)
                .range(element)
                .create()
        }
    }

    private fun processReferences(element: PsiElement, holder: AnnotationHolder) {
        if (element !is MonkeySimpleRefExpr) {
            return
        }
        if (element.resolve() == null && !builtInFunction(element)) {
            holder.newAnnotation(HighlightSeverity.ERROR, "Can't find a variant declaration")
                .range(element)
                .create()
        }
    }

    private fun builtInFunction(element: MonkeySimpleRefExpr): Boolean {
        return builtInFunctionNames.contains(element.ident.text) && element.parent is MonkeyCallExpr
    }
}
