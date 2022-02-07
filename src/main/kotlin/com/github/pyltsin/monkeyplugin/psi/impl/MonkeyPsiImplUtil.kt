package com.github.pyltsin.monkeyplugin.psi.impl

import com.github.pyltsin.monkeyplugin.psi.*
import com.intellij.psi.PsiElement
import com.intellij.psi.search.PsiElementProcessor
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.containers.OrderedSet

class MonkeyPsiImplUtil {
    companion object {
        @JvmStatic
        fun resolveType(expr: MonkeyExpr): MonkeyType {
            //todo
            return UNKNOWN_TYPE
        }

        @JvmStatic
        fun getReference(o: MonkeySimpleRefExpr): MonkeyReferenceBase {
            val myText = o.ident.text
            val myResult = OrderedSet<PsiElement>()
            return object : MonkeyReferenceBase(o, o.textRange) {
                override fun resolveInner(incompleteCode: Boolean): List<PsiElement> {
                    var parent: PsiElement? = PsiTreeUtil.getParentOfType(o, MonkeyStatement::class.java)
                    while (parent !is MonkeyAll && parent != null) {
                        var parentNext = parent.prevSibling
                        if (parentNext is MonkeyLetExpr && myText == parentNext.ident.text) {
                            myResult.add(element)
                        }
                        if (parentNext == null) {
                            parentNext = parent.parent
                        }
                        parent = parentNext
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
        fun getReference(o: MonkeyLetExpr): MonkeyReferenceBase {
            val myText = o.ident.text
            val myResult = OrderedSet<PsiElement>()
            return object : MonkeyReferenceBase(o, o.textRange) {
                override fun resolveInner(incompleteCode: Boolean): List<PsiElement> {
                    val processor = object : PsiElementProcessor<PsiElement> {
                        override fun execute(element: PsiElement): Boolean {
                            if (element is MonkeySimpleRefExpr && myText == element.ident.text) {
                                myResult.add(element)
                            }
                            if (element is MonkeyLetExpr && myText == element.ident.text) {
                                return false
                            }
                            return true
                        }
                    }
                    val statement = o.parent
                    var nextSibling = statement.nextSibling
                    while (nextSibling != null) {
                        if (nextSibling is MonkeyLetExpr && myText == nextSibling.ident.text) {
                            break
                        }
                        PsiTreeUtil.processElements(nextSibling, processor)
                        nextSibling = nextSibling.nextSibling
                    }
                    return myResult
                }
            }
        }

        @JvmStatic
        fun resolve(o: MonkeyLetExpr): PsiElement? {
            return o.reference?.resolve()
        }
    }
}
