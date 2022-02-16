package com.github.pyltsin.monkeyplugin.usages

import com.github.pyltsin.monkeyplugin.MonkeyTypes
import com.github.pyltsin.monkeyplugin.lexer.MonkeyFlexAdapter
import com.github.pyltsin.monkeyplugin.psi.MonkeyNamedElement
import com.github.pyltsin.monkeyplugin.psi.MonkeyVarDefinition
import com.intellij.lang.HelpID
import com.intellij.lang.cacheBuilder.DefaultWordsScanner
import com.intellij.lang.cacheBuilder.WordsScanner
import com.intellij.lang.findUsages.FindUsagesProvider
import com.intellij.psi.ElementDescriptionUtil
import com.intellij.psi.PsiElement
import com.intellij.psi.tree.TokenSet
import com.intellij.usageView.UsageViewLongNameLocation
import com.intellij.usageView.UsageViewShortNameLocation

class MonkeyFindUsagesProvider : FindUsagesProvider {
    override fun getWordsScanner(): WordsScanner {
        return DefaultWordsScanner(
            MonkeyFlexAdapter(),
            TokenSet.create(MonkeyTypes.IDENT, MonkeyTypes.VAR_DEFINITION, MonkeyTypes.SIMPLE_REF_EXPR),
            TokenSet.EMPTY,
            TokenSet.create(MonkeyTypes.STRING)
        )
    }

    override fun canFindUsagesFor(psiElement: PsiElement): Boolean {
        return psiElement is MonkeyNamedElement
    }

    override fun getHelpId(psiElement: PsiElement): String {
        return HelpID.FIND_OTHER_USAGES
    }

    override fun getType(element: PsiElement): String {
        return when (element) {
            is MonkeyVarDefinition -> "variable"
            else -> "unknown"
        }
    }

    override fun getDescriptiveName(element: PsiElement): String {
        return ElementDescriptionUtil.getElementDescription(element, UsageViewLongNameLocation.INSTANCE)
    }

    override fun getNodeText(element: PsiElement, useFullName: Boolean): String {
        return ElementDescriptionUtil.getElementDescription(element, UsageViewShortNameLocation.INSTANCE)
    }
}
