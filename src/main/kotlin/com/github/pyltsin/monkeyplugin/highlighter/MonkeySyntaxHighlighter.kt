package com.github.pyltsin.monkeyplugin.highlighter

import com.github.pyltsin.monkeyplugin.lexer.MonkeyFlexAdapter
import com.github.pyltsin.monkeyplugin.parser.MonkeyParserDefinition
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType

class MonkeySyntaxHighlighter : SyntaxHighlighterBase() {
    private val attributes: Map<IElementType, TextAttributesKey> = HashMap()

    companion object{
        val GLOBAL_IDENTIFIER = TextAttributesKey.createTextAttributesKey("GLOBAL_IDENTIFIER", DefaultLanguageHighlighterColors.GLOBAL_VARIABLE)
        val KEYWORDS = TextAttributesKey.createTextAttributesKey("MONKEY_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
        val NUMBER = TextAttributesKey.createTextAttributesKey("MOKNEY_NUMBER", DefaultLanguageHighlighterColors.NUMBER)
        val STRING = TextAttributesKey.createTextAttributesKey("MOKNEY_STRING", DefaultLanguageHighlighterColors.STRING)
        val OPERATORS = TextAttributesKey.createTextAttributesKey("MOKNEY_OPERATORS", DefaultLanguageHighlighterColors.OPERATION_SIGN)
        val IDENTIFIER = TextAttributesKey.createTextAttributesKey("MOKNEY_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER)
        val BAD_CHARACTER =
            TextAttributesKey.createTextAttributesKey("MOKNEY_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)
        val COMMA =
            TextAttributesKey.createTextAttributesKey("MOKNEY_COMMA", DefaultLanguageHighlighterColors.COMMA)
        val SEMICOLON =
            TextAttributesKey.createTextAttributesKey("GO_SEMICOLON", DefaultLanguageHighlighterColors.SEMICOLON)
        val COLON = TextAttributesKey.createTextAttributesKey("GO_COLON", HighlighterColors.TEXT)

        val BRACKETS = TextAttributesKey.createTextAttributesKey("MOKNEY_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS)
        val PARENTHESES = TextAttributesKey.createTextAttributesKey("MOKNEY_PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES)
        val BRACES = TextAttributesKey.createTextAttributesKey("MOKNEY_BRACES", DefaultLanguageHighlighterColors.BRACES)
    }

    init {
        fillMap(attributes, MonkeyParserDefinition.KEYWORDS, KEYWORDS)
        fillMap(attributes, MonkeyParserDefinition.NUMBERS, NUMBER)
        fillMap(attributes, MonkeyParserDefinition.STRINGS, STRING)
        fillMap(attributes, MonkeyParserDefinition.OPERATORS, OPERATORS)
        fillMap(attributes, MonkeyParserDefinition.IDENTIFIER, IDENTIFIER)
        fillMap(attributes, MonkeyParserDefinition.BAD_CHARACTER, BAD_CHARACTER)
        fillMap(attributes, MonkeyParserDefinition.COMMA, COMMA)
        fillMap(attributes, MonkeyParserDefinition.PARENTHESES, PARENTHESES)
        fillMap(attributes, MonkeyParserDefinition.BRACES, BRACES)
        fillMap(attributes, MonkeyParserDefinition.BRACKETS, BRACKETS)
        fillMap(attributes, MonkeyParserDefinition.COLON, COLON)
        fillMap(attributes, MonkeyParserDefinition.SEMICOLON, SEMICOLON)
    }

    override fun getHighlightingLexer(): Lexer {
        return MonkeyFlexAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
        return pack(attributes[tokenType])
    }
}
