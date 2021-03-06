package com.github.pyltsin.monkeyplugin.psi.impl

import com.github.pyltsin.monkeyplugin.psi.MonkeyVarDefinition
import com.github.pyltsin.monkeyplugin.stubs.MonkeyVarDefinitionStub
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.text.StringUtil
import com.intellij.psi.PsiElement
import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.util.PsiTreeUtil

abstract class MonkeyVarDefinitionBaseImpl :
    MonkeyNamedStubbedPsiElementBase<MonkeyVarDefinitionStub>,
    MonkeyVarDefinition {
    constructor(stub: MonkeyVarDefinitionStub, nodeType: IStubElementType<*, *>) : super(stub, nodeType)
    constructor(node: ASTNode) : super(node)

    override fun getName(): String {
        val stub = stub
        return if (stub != null) StringUtil.notNullize(stub.name) else this.nameIdentifier!!.text
    }

    override fun getNameIdentifier(): PsiElement? {
        return this.node.psi
    }

    override fun setName(name: String): PsiElement {
        val e: PsiElement =
            MonkeyElementTextFactory.createStatementFromText(project, "let $name = 1")
        val newLetExpr = PsiTreeUtil.findChildOfType(e, MonkeyVarDefinition::class.java)
        if (newLetExpr != null) {
            this.replace(newLetExpr)
        }
        return this
    }
}
