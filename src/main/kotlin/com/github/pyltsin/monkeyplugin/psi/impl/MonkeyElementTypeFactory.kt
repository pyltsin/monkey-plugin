package com.github.pyltsin.monkeyplugin.psi.impl

import com.github.pyltsin.monkeyplugin.stubs.types.MonkeyLetExpressionStubElementType
import com.intellij.psi.tree.IElementType

object MonkeyElementTypeFactory {
    @JvmStatic
    fun factory(name: String): IElementType {
        if (name == "LET_EXPR") return MonkeyLetExpressionStubElementType(name)
        throw RuntimeException("Unknown element type: $name")
    }
}
