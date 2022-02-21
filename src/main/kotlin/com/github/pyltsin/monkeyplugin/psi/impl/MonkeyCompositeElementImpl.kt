package com.github.pyltsin.monkeyplugin.psi.impl

import com.github.pyltsin.monkeyplugin.psi.MonkeyCompositeElement
import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.navigation.ItemPresentation
import com.intellij.usageView.UsageViewUtil
import javax.swing.Icon

class MonkeyCompositeElementImpl(node: ASTNode) : ASTWrapperPsiElement(node), MonkeyCompositeElement {
    override fun toString(): String {
        return node.elementType.toString()
    }

    override fun getPresentation(): ItemPresentation {
        val text = UsageViewUtil.createNodeText(this)
        return object : ItemPresentation {
            override fun getPresentableText(): String {
                return text
            }

            override fun getLocationString(): String {
                return containingFile.name
            }

            override fun getIcon(b: Boolean): Icon? {
                return null
            }
        }
    }
}
