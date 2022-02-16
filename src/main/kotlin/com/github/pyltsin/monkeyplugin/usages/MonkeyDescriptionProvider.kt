package com.github.pyltsin.monkeyplugin.usages

import com.github.pyltsin.monkeyplugin.psi.MonkeyNamedElement
import com.intellij.codeInsight.highlighting.HighlightUsagesDescriptionLocation
import com.intellij.psi.ElementDescriptionLocation
import com.intellij.psi.ElementDescriptionProvider
import com.intellij.psi.PsiElement
import com.intellij.usageView.UsageViewLongNameLocation
import com.intellij.usageView.UsageViewShortNameLocation

class MonkeyDescriptionProvider : ElementDescriptionProvider {
    override fun getElementDescription(o: PsiElement, location: ElementDescriptionLocation): String? {
        return if (location === UsageViewShortNameLocation.INSTANCE || location === UsageViewLongNameLocation.INSTANCE || location === HighlightUsagesDescriptionLocation.INSTANCE
        ) {
            if (o is MonkeyNamedElement) o.name else null
        } else null
    }
}
