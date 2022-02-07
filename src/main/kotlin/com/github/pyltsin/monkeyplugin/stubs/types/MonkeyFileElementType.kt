package com.github.pyltsin.monkeyplugin.stubs.types

import com.github.pyltsin.monkeyplugin.MonkeyLanguage
import com.github.pyltsin.monkeyplugin.stubs.MonkeyFileStub
import com.intellij.psi.stubs.StubElement
import com.intellij.psi.stubs.StubInputStream
import com.intellij.psi.stubs.StubOutputStream
import com.intellij.psi.tree.IStubFileElementType
import org.jetbrains.annotations.NonNls

class MonkeyFileElementType(language: MonkeyLanguage?) : IStubFileElementType<MonkeyFileStub>(language) {
    override fun getStubVersion(): Int = VERSION

    override fun serialize(stub: MonkeyFileStub, dataStream: StubOutputStream) = Unit

    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?): MonkeyFileStub =
        MonkeyFileStub(null)

    @NonNls
    override fun getExternalId(): String = super.getExternalId() + ".FILE"

    companion object {
        @JvmField
        val INSTANCE = MonkeyFileElementType(MonkeyLanguage.INSTANCE)

        private const val VERSION = 3 // Change the version if you want to re-index Frege
    }
}
