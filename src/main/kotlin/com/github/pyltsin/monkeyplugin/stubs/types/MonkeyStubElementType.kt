package com.github.pyltsin.monkeyplugin.stubs.types

import com.github.pyltsin.monkeyplugin.MonkeyLanguage
import com.github.pyltsin.monkeyplugin.psi.MonkeyCompositeElement
import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.stubs.StubElement

abstract class MonkeyStubElementType<S : StubElement<T>, T : MonkeyCompositeElement?>
    (debugName: String) :
    IStubElementType<S, T>(debugName, MonkeyLanguage.INSTANCE) {
    override fun getExternalId(): String {
        return "monkey." + super.toString()
    }
}
