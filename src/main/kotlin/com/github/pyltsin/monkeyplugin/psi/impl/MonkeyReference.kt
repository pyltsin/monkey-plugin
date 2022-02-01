package com.github.pyltsin.monkeyplugin.psi.impl

import com.intellij.openapi.util.TextRange
import com.intellij.psi.*
import com.intellij.psi.impl.source.resolve.ResolveCache

abstract class MonkeyReferenceBase(@JvmField protected val psiElement: PsiElement, range: TextRange) :
    PsiReferenceBase<PsiElement?>(psiElement, range), PsiPolyVariantReference {

    protected abstract fun resolveInner(incompleteCode: Boolean): List<PsiElement>

    override fun multiResolve(incompleteCode: Boolean): Array<ResolveResult> {
        return ResolveCache.getInstance(psiElement.project).resolveWithCaching(
            this, { fregeReferenceBase, _ ->
                fregeReferenceBase.resolveInner(false)
                    .map { PsiElementResolveResult(it) }
                    .toTypedArray()
            },
            true, false
        )
    }

    override fun resolve(): PsiElement? {
        val resolveResults = multiResolve(false)
        return if (resolveResults.size == 1) resolveResults[0].element else null
    }

    override fun equals(other: Any?): Boolean {
        return if (other is MonkeyReferenceBase) psiElement == other.psiElement else false
    }

    override fun hashCode(): Int {
        return psiElement.hashCode()
    }
}
