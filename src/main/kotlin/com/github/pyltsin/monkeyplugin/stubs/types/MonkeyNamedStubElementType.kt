package com.github.pyltsin.monkeyplugin.stubs.types

import com.github.pyltsin.monkeyplugin.psi.MonkeyNamedElement
import com.github.pyltsin.monkeyplugin.stubs.MonkeyLetNameIndex
import com.intellij.psi.stubs.IndexSink
import com.intellij.psi.stubs.NamedStubBase

abstract class MonkeyNamedStubElementType<S : NamedStubBase<T>, T : MonkeyNamedElement>
    (debugName: String) : MonkeyStubElementType<S, T>(debugName) {
    override fun indexStub(stub: S, sink: IndexSink) {
        val name = stub.name
        if (name != null) {
            sink.occurrence(MonkeyLetNameIndex.KEY, name)
        }
    }
}
