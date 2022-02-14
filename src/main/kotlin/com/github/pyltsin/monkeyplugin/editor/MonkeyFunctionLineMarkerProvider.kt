package com.github.pyltsin.monkeyplugin.editor

import com.github.pyltsin.monkeyplugin.MonkeyTypes
import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.codeInsight.daemon.LineMarkerProvider
import com.intellij.icons.AllIcons
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import com.intellij.util.FunctionUtil
import java.util.function.Supplier

class MonkeyFunctionLineMarkerProvider : LineMarkerProvider {
    override fun getLineMarkerInfo(element: PsiElement): LineMarkerInfo<*>? {
        if (element.elementType == MonkeyTypes.FUNCTION) {
            return FunctionDefinitionMarkerInfo(element)
        }
        return null
    }
}

class FunctionDefinitionMarkerInfo constructor(element: PsiElement) :
    LineMarkerInfo<PsiElement?>(
        element,
        element.textRange,
        AllIcons.Gutter.ImplementingFunctionalInterface,
        FunctionUtil.constant("Function definition"),
        null,
        GutterIconRenderer.Alignment.RIGHT,
        Supplier<String> { "Function definition" }
    )
