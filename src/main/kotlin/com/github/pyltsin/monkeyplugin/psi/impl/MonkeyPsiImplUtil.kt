package com.github.pyltsin.monkeyplugin.psi.impl

import com.github.pyltsin.monkeyplugin.psi.MonkeyExpr
import com.github.pyltsin.monkeyplugin.psi.MonkeySimpleRefExpr
import com.intellij.psi.PsiElement

class MonkeyPsiImplUtil {
    companion object {
        @JvmStatic
        fun resolveType(expr: MonkeyExpr): MonkeyType {
            //todo
            return UNKNOWN_TYPE
        }

        @JvmStatic
        fun getReference(o: MonkeySimpleRefExpr): MonkeyReferenceBase? {
            return null
        }

        @JvmStatic
        fun resolve(o: MonkeySimpleRefExpr): PsiElement? {
            return o.reference?.resolve()
        }
    }
}
