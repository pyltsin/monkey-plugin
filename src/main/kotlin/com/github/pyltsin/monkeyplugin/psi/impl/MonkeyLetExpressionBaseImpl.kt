package com.github.pyltsin.monkeyplugin.psi.impl

import com.github.pyltsin.monkeyplugin.psi.MonkeyLetExpr
import com.github.pyltsin.monkeyplugin.psi.MonkeyLetStatement
import com.github.pyltsin.monkeyplugin.psi.impl.MonkeyPsiImplUtil.Companion.getReference
import com.github.pyltsin.monkeyplugin.stubs.MonkeyLetExpressionStub
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.text.StringUtil
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.stubs.IStubElementType

abstract class MonkeyLetExpressionBaseImpl :
    MonkeyNamedStubbedPsiElementBase<MonkeyLetExpressionStub>,
    MonkeyLetExpr {
    constructor(stub: MonkeyLetExpressionStub, nodeType: IStubElementType<*, *>) : super(stub, nodeType)
    constructor(node: ASTNode) : super(node)

    override fun getName(): String {
        val stub = stub
        return if (stub != null) StringUtil.notNullize(stub.name) else this.nameIdentifier!!.text
    }

    override fun getNameIdentifier(): PsiElement? {
        return this.node.psi
    }

    override fun getReference(): PsiReference? {
        return getReference(this)
    }

    //todo
    override fun setName(name: String): PsiElement {
        val e: PsiElement =
            MonkeyElementFactory.createExpressionFromText(project, "let $name = 1")
        val monkeyLetStatement = e as MonkeyLetStatement
        val letExpr = monkeyLetStatement.letExpr!!
        this.replace(letExpr)
        return this
    }
}
