package com.github.pyltsin.monkeyplugin.psi.impl

import com.github.pyltsin.monkeyplugin.psi.*
import com.intellij.openapi.util.RecursionManager
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.util.CachedValueProvider
import com.intellij.psi.util.CachedValuesManager
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.containers.OrderedSet

class MonkeyPsiImplUtil {
    companion object {
        @JvmStatic
        fun resolveType(expr: MonkeyExpr): MonkeyTypeResolvedResult {
            val result: MonkeyTypeResolvedResult? = RecursionManager.doPreventingRecursion(expr, true) {
                CachedValuesManager.getCachedValue(expr) {
                    CachedValueProvider.Result.create(TypeResolver.resolveType(expr), expr)
                }
            }
            return result ?: MonkeyTypeResolvedResult(UNKNOWN_TYPE, MonkeyTypeResolvedError("Can't resolve type"))
        }

        @JvmStatic
        fun setName(expr: MonkeySimpleRefExpr, name: String): PsiElement {
            val e: PsiElement = MonkeyElementTextFactory.createStatementFromText(expr.project, "$name + 1")
            val newLetExpr = PsiTreeUtil.findChildOfType(e, MonkeySimpleRefExpr::class.java)
            if (newLetExpr != null) {
                expr.replace(newLetExpr)
            }
            return expr
        }

        @JvmStatic
        fun getReference(o: MonkeySimpleRefExpr): MonkeyReferenceBase {
            val myText = o.ident.text
            val myResult = OrderedSet<PsiElement>()
            return object : MonkeyReferenceBase(o, TextRange(0, o.textLength)) {
                override fun handleElementRename(newElementName: String): PsiElement? {
                    return when (val currentElement = element) {
                        is MonkeySimpleRefExpr -> setName(currentElement, newElementName)
                        else -> return null
                    }
                }

                override fun isReferenceTo(element: PsiElement): Boolean {
                    val resolved = resolve()
                    val manager = getElement().manager
                    return manager.areElementsEquivalent(resolved, element)
                            || manager.areElementsEquivalent(resolved?.parent, element)
                }

                override fun resolveInner(incompleteCode: Boolean): List<PsiElement> {
                    var parent: PsiElement? = PsiTreeUtil.getParentOfType(o, MonkeyStatement::class.java)
                    while (parent !is MonkeyAll && parent != null) {
                        var parentNext = parent.prevSibling
                        while (parentNext != null) {
                            val firstChild = parentNext.firstChild
                            if (firstChild is MonkeyLetStatement) {
                                val ident = firstChild.varDefinition?.ident
                                if (incompleteCode || ident?.textMatches(myText) == true) {
                                    myResult.add(firstChild.varDefinition)
                                }
                            }

                            if (parentNext is MonkeyParamGroup) {
                                parentNext.varDefinitionList.forEach {
                                    if (incompleteCode || it.ident.text == myText) {
                                        myResult.add(it)
                                    }
                                }
                            }
                            parentNext = parentNext.prevSibling
                        }
                        parent = parent.parent
                    }
                    return myResult
                }
            }
        }

        @JvmStatic
        fun resolve(o: MonkeySimpleRefExpr): PsiElement? {
            return o.reference.resolve()
        }
    }
}
