package com.github.pyltsin.monkeyplugin.stubs

import com.github.pyltsin.monkeyplugin.psi.MonkeyNamedElement
import com.intellij.psi.stubs.StringStubIndexExtension
import com.intellij.psi.stubs.StubIndexKey

class MonkeyLetNameIndex : StringStubIndexExtension<MonkeyNamedElement>() {
    override fun getVersion(): Int {
        return super.getVersion() + VERSION
    }

    override fun getKey(): StubIndexKey<String, MonkeyNamedElement> {
        return KEY
    }

    companion object {
        val KEY: StubIndexKey<String, MonkeyNamedElement> =
            StubIndexKey.createIndexKey("monkey.let.name")
        const val VERSION = 0
    }
}
