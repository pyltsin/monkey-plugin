package com.github.pyltsin.monkeyplugin.stubs

import com.github.pyltsin.monkeyplugin.psi.MonkeyNamedElement
import com.intellij.psi.stubs.StringStubIndexExtension
import com.intellij.psi.stubs.StubIndexKey

class MonkeyVarNameIndex : StringStubIndexExtension<MonkeyNamedElement>() {
    override fun getVersion(): Int {
        return super.getVersion() + VERSION
    }

    override fun getKey(): StubIndexKey<String, MonkeyNamedElement> {
        return KEY
    }

    companion object {
        val KEY: StubIndexKey<String, MonkeyNamedElement> =
            StubIndexKey.createIndexKey("monkey.var.name")
        const val VERSION = 0
    }
}
