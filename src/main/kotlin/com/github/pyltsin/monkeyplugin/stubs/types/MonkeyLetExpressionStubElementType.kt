package com.github.pyltsin.monkeyplugin.stubs.types

import com.github.pyltsin.monkeyplugin.psi.MonkeyAll
import com.github.pyltsin.monkeyplugin.psi.MonkeyLetExpr
import com.github.pyltsin.monkeyplugin.psi.impl.MonkeyLetExprImpl
import com.github.pyltsin.monkeyplugin.stubs.MonkeyLetExpressionStub
import com.intellij.lang.ASTNode
import com.intellij.psi.stubs.StubElement
import com.intellij.psi.stubs.StubInputStream
import com.intellij.psi.stubs.StubOutputStream

class MonkeyLetExpressionStubElementType(debugName: String) :
    MonkeyNamedStubElementType<MonkeyLetExpressionStub, MonkeyLetExpr>(debugName) {
    override fun serialize(stub: MonkeyLetExpressionStub, dataStream: StubOutputStream) {
        dataStream.writeName(stub.name)
    }

    override fun shouldCreateStub(node: ASTNode?): Boolean {
        val psi = node?.psi
        if (psi !is MonkeyLetExpr) {
            return false
        }
        return psi.parent?.parent?.parent is MonkeyAll
    }

    override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?): MonkeyLetExpressionStub {
        return MonkeyLetExpressionStub(parentStub, this, dataStream.readName())
    }

    override fun createPsi(stub: MonkeyLetExpressionStub): MonkeyLetExpr {
        return MonkeyLetExprImpl(stub, this)
    }

    override fun createStub(psi: MonkeyLetExpr, parentStub: StubElement<*>?): MonkeyLetExpressionStub {
        return MonkeyLetExpressionStub(parentStub, this, psi.name)
    }
}
