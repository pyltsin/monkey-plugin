package com.github.pyltsin.monkeyplugin.editor

import com.github.pyltsin.monkeyplugin.MonkeyTypes
import com.github.pyltsin.monkeyplugin.parser.MonkeyParserDefinition
import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType

class MonkeyBraceMatcher : PairedBraceMatcher {

    private val bracePairs = arrayOf(
        BracePair(MonkeyTypes.LPAREN, MonkeyTypes.RPAREN, false),
        BracePair(MonkeyTypes.LBRACE, MonkeyTypes.RBRACE, true),
        BracePair(MonkeyTypes.LBRACKET, MonkeyTypes.RBRACKET, false)
    )

    override fun getPairs(): Array<BracePair> {
       return bracePairs
    }

    override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType, contextType: IElementType?): Boolean {
       return !MonkeyParserDefinition.STRINGS.contains(contextType) &&
               contextType != MonkeyTypes.LPAREN &&
               contextType != MonkeyTypes.LBRACE &&
               contextType != MonkeyTypes.LBRACKET
    }

    override fun getCodeConstructStart(file: PsiFile?, openingBraceOffset: Int): Int {
        return openingBraceOffset
    }
}
