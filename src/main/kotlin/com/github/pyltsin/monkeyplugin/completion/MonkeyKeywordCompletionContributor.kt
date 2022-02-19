package com.github.pyltsin.monkeyplugin.completion

import com.github.pyltsin.monkeyplugin.psi.MonkeyIfExpr
import com.github.pyltsin.monkeyplugin.psi.MonkeyLetStatement
import com.github.pyltsin.monkeyplugin.psi.MonkeyStatement
import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.patterns.ElementPattern
import com.intellij.patterns.PlatformPatterns
import com.intellij.patterns.PsiElementPattern
import com.intellij.psi.PsiElement

class MonkeyKeywordCompletionContributor : CompletionContributor() {
    private fun registerStandardCompletion(
        pattern: ElementPattern<out PsiElement?>,
        needSpace: Boolean,
        vararg keywords: String
    ) {
        extend(
            CompletionType.BASIC,
            pattern,
            MonkeyKeywordCompletionProvider(needSpace, listOf(*keywords))
        )
    }

    init {
        registerStandardCompletion(ifPattern(), false, IF)
        registerStandardCompletion(elsePattern(), false, ELSE)
        registerStandardCompletion(letPattern(), true, LET)
        registerStandardCompletion(funPattern(), false, FUNCTION)
    }


    companion object {
        private const val LET = "let"
        private const val FUNCTION = "fn"
        private const val IF = "if"
        private const val ELSE = "else"
        private const val ASSIGN = "="

        fun ifPattern(): PsiElementPattern.Capture<PsiElement> {
            return PlatformPatterns.psiElement().andOr(
                PlatformPatterns.psiElement().withSuperParent(2, MonkeyLetStatement::class.java).and(
                    PlatformPatterns.psiElement().afterLeaf(ASSIGN)
                ),
                PlatformPatterns.psiElement().insideStarting(PlatformPatterns.psiElement(MonkeyStatement::class.java))
                    .and(PlatformPatterns.psiElement().beforeLeaf(PlatformPatterns.psiElement().isNull))
            )
        }

        fun letPattern(): PsiElementPattern.Capture<PsiElement> {
            return PlatformPatterns.psiElement()
                .insideStarting(PlatformPatterns.psiElement(MonkeyStatement::class.java))
                .and(PlatformPatterns.psiElement().beforeLeaf(PlatformPatterns.psiElement().isNull))
        }

        fun elsePattern(): PsiElementPattern.Capture<PsiElement> {
            return PlatformPatterns.psiElement().withSuperParent(
                2, PlatformPatterns.psiElement().afterSiblingSkipping(
                    PlatformPatterns.psiElement().whitespaceCommentEmptyOrError(),
                    PlatformPatterns.psiElement().withFirstChild(
                        PlatformPatterns.psiElement(MonkeyIfExpr::class.java)
                    )
                )
            )
        }

        fun funPattern(): PsiElementPattern.Capture<PsiElement> {
            return PlatformPatterns.psiElement().andOr(
                PlatformPatterns.psiElement().withSuperParent(2, MonkeyLetStatement::class.java).and(
                    PlatformPatterns.psiElement().afterLeaf(ASSIGN)
                ),
                PlatformPatterns.psiElement().insideStarting(PlatformPatterns.psiElement(MonkeyStatement::class.java))
                    .and(PlatformPatterns.psiElement().beforeLeaf(PlatformPatterns.psiElement().isNull))
            )
        }
    }
}
