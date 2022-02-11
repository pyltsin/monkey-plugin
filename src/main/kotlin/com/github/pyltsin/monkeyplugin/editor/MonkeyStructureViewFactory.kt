package com.github.pyltsin.monkeyplugin.editor

import com.github.pyltsin.monkeyplugin.psi.*
import com.intellij.ide.structureView.*
import com.intellij.ide.structureView.StructureViewModel.ElementInfoProvider
import com.intellij.ide.structureView.impl.common.PsiTreeElementBase
import com.intellij.ide.util.treeView.smartTree.Sorter
import com.intellij.lang.PsiStructureViewFactory
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.PsiTreeUtil

//show only first level definition
class MonkeyStructureViewFactory : PsiStructureViewFactory {
    override fun getStructureViewBuilder(psiFile: PsiFile): StructureViewBuilder? {
        return object : TreeBasedStructureViewBuilder() {
            override fun createStructureViewModel(editor: Editor?): StructureViewModel {
                return MonkeyModel(psiFile, editor)
            }

            override fun isRootNodeShown(): Boolean {
                return false
            }
        }
    }
}

class MonkeyModel(psiFile: PsiFile, editor: Editor?) :
    StructureViewModelBase(psiFile, MonkeyStructureViewElement(psiFile)), ElementInfoProvider {
    init {
        withSuitableClasses(
            MonkeyFile::class.java,
            MonkeyNamedElement::class.java,
        )
            .withSorters(Sorter.ALPHA_SORTER)

    }

    override fun isAlwaysShowsPlus(element: StructureViewTreeElement?): Boolean {
        return false
    }

    override fun isAlwaysLeaf(element: StructureViewTreeElement?): Boolean {
        return element?.value is MonkeySimpleRefExpr
    }
}

class MonkeyStructureViewElement(e: PsiElement) : PsiTreeElementBase<PsiElement?>(e) {
    override fun getPresentableText(): String {
        val currentElement = element
        if (currentElement is MonkeyFile) {
            return "File:" + currentElement.name
        }
        if (currentElement is MonkeyNamedElement) {
            return "Element:" + currentElement.name
        }
        return "Undefined"
    }

    override fun getChildrenBase(): Collection<StructureViewTreeElement> {
        val result: MutableList<StructureViewTreeElement> = arrayListOf()
        val element = element
        if (element is MonkeyFile) {
            val monkeyAll: MonkeyAll = PsiTreeUtil.findChildOfType(element, MonkeyAll::class.java) ?: return result
            for (next: MonkeyStatement in monkeyAll.statementList) {
                val letStatement: MonkeyLetStatement? = next.letStatement
                letStatement?.varDefinition?.let { it ->
                    result.add(MonkeyStructureViewElement(it))
                }
            }
        }
        return result
    }
}
