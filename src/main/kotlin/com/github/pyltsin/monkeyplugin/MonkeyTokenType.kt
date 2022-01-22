package com.github.pyltsin.monkeyplugin

import com.intellij.psi.tree.IElementType

class MonkeyTokenType(
    debugName: String
) : IElementType(debugName, MonkeyLanguage.INSTANCE) {
    override fun toString(): String {
        return "MonkeyTokenType." + super.toString()
    }
}