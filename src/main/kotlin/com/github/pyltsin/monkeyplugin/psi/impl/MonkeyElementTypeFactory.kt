package com.github.pyltsin.monkeyplugin.psi.impl

import com.github.pyltsin.monkeyplugin.stubs.types.MonkeyVarDefinitionStubElementType
import com.intellij.psi.tree.IElementType

object MonkeyElementTypeFactory {
    @JvmStatic
    fun factory(name: String): IElementType {
        if (name == "VAR_DEFINITION") return MonkeyVarDefinitionStubElementType(name)
        throw RuntimeException("Unknown element type: $name")
    }
}
