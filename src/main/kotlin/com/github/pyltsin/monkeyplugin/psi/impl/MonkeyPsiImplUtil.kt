package com.github.pyltsin.monkeyplugin.psi.impl

import com.github.pyltsin.monkeyplugin.psi.*
import com.intellij.openapi.util.RecursionManager
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.search.PsiElementProcessor
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
            val e: PsiElement =
                MonkeyElementTextFactory.createStatementFromText(expr.project, "$name + 1")
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
                override fun resolveInner(incompleteCode: Boolean): List<PsiElement> {
                    var parent: PsiElement? = PsiTreeUtil.getParentOfType(o, MonkeyStatement::class.java)
                    while (parent !is MonkeyAll && parent != null) {
                        var parentNext = parent.prevSibling
                        while (parentNext != null) {
                            val firstChild = parentNext.firstChild
                            if (firstChild is MonkeyLetStatement) {
                                val ident = firstChild.varDefinition?.ident
                                if (ident?.textMatches(myText) == true) {
                                    myResult.add(ident)
                                }
                            }

                            if (parentNext is MonkeyParamGroup) {
                                parentNext.varDefinitionList.forEach {
                                    if (it.ident.text == myText) {
                                        myResult.add(it.ident)
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

        @JvmStatic
        fun getUsages(o: MonkeyVarDefinition): MonkeyReferenceBase {
            val myText = o.ident.text
            val myResult = OrderedSet<PsiElement>()
            return object : MonkeyReferenceBase(o, o.textRange) {
                override fun resolveInner(incompleteCode: Boolean): List<PsiElement> {
                    val processor = object : PsiElementProcessor<PsiElement> {
                        override fun execute(element: PsiElement): Boolean {
                            if (element is MonkeySimpleRefExpr && myText == element.ident.text) {
                                myResult.add(element.ident)
                            }
                            if (element is MonkeyVarDefinition && myText == element.ident.text) {
                                return false
                            }
                            return true
                        }
                    }
                    val statement = o.parent?.parent
                    var nextSibling: PsiElement?
                    nextSibling = if (statement is MonkeyFuncExpr) {
                        PsiTreeUtil.findChildOfType(statement, MonkeyBlockState::class.java)?.firstChild
                    } else {
                        statement?.nextSibling
                    }
                    while (nextSibling != null) {
                        if (nextSibling is MonkeyVarDefinition && myText == nextSibling.ident.text) {
                            break
                        }
                        PsiTreeUtil.processElements(nextSibling, processor)
                        nextSibling = nextSibling.nextSibling
                    }
                    return myResult
                }
            }
        }
    }
}
