package com.github.pyltsin.monkeyplugin.stubs.types

import com.github.pyltsin.monkeyplugin.psi.MonkeyAll
import com.github.pyltsin.monkeyplugin.psi.MonkeyLetExpr
import com.github.pyltsin.monkeyplugin.psi.impl.MonkeyVarDefinitionImpl
import com.github.pyltsin.monkeyplugin.stubs.MonkeyVarDefinitionStub
import com.intellij.lang.ASTNode
import com.intellij.psi.stubs.StubElement
import com.intellij.psi.stubs.StubInputStream
import com.intellij.psi.stubs.StubOutputStream

class MonkeyVarDefinitionStubElementType(debugName: String) :
    MonkeyNamedStubElementType<MonkeyVarDefinitionStub, MonkeyLetExpr>(debugName) {
    override fun serialize(stub: MonkeyVarDefinitionStub, dataStream: StubOutputStream) {
        dataStream.writeName(stub.name)
    }

    override fun shouldCreateStub(node: ASTNode?): Boolean {
        val psi = node?.psi
        if (psi !is MonkeyLetExpr) {
            return false
        }
        return psi.parent?.parent?.parent is MonkeyAll
    }

    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?): MonkeyVarDefinitionStub {
        return MonkeyVarDefinitionStub(parentStub, this, dataStream.readName())
    }

    override fun createPsi(stub: MonkeyVarDefinitionStub): MonkeyLetExpr {
        return MonkeyVarDefinitionImpl(stub, this)
    }

    override fun createStub(psi: MonkeyLetExpr, parentStub: StubElement<*>?): MonkeyVarDefinitionStub {
        return MonkeyVarDefinitionStub(parentStub, this, psi.name)
    }
}
