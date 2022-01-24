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
    private val ATTRIBUTES: Map<IElementType, TextAttributesKey> = HashMap()

    companion object{
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
        //todo comment
//    val LINE_COMMENT =
//        TextAttributesKey.createTextAttributesKey("MOKNEY_LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
//    val BLOCK_COMMENT =
//        TextAttributesKey.createTextAttributesKey(
//            "MOKNEY_BLOCK_COMMENT",
//            DefaultLanguageHighlighterColors.BLOCK_COMMENT
//        )
    }

    init {
        fillMap(ATTRIBUTES, MonkeyParserDefinition.KEYWORDS, KEYWORDS)
        fillMap(ATTRIBUTES, MonkeyParserDefinition.NUMBERS, NUMBER)
        fillMap(ATTRIBUTES, MonkeyParserDefinition.STRINGS, STRING)
        fillMap(ATTRIBUTES, MonkeyParserDefinition.OPERATORS, OPERATORS)
        fillMap(ATTRIBUTES, MonkeyParserDefinition.IDENTIFIER, IDENTIFIER)
        fillMap(ATTRIBUTES, MonkeyParserDefinition.BAD_CHARACTER, BAD_CHARACTER)
        fillMap(ATTRIBUTES, MonkeyParserDefinition.COMMA, COMMA)
        fillMap(ATTRIBUTES, MonkeyParserDefinition.PARENTHESES, PARENTHESES)
        fillMap(ATTRIBUTES, MonkeyParserDefinition.BRACES, BRACES)
        fillMap(ATTRIBUTES, MonkeyParserDefinition.BRACKETS, BRACKETS)
        fillMap(ATTRIBUTES, MonkeyParserDefinition.COLON, COLON)
        fillMap(ATTRIBUTES, MonkeyParserDefinition.SEMICOLON, SEMICOLON)

        //todo comment
//        fillMap(ATTRIBUTES, LINE_COMMENT, GoParserDefinition.LINE_COMMENT)
//        fillMap(
//            ATTRIBUTES,
//            BLOCK_COMMENT,
//            GoParserDefinition.MULTILINE_COMMENT
//        )

    }

    override fun getHighlightingLexer(): Lexer {
        return MonkeyFlexAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
        return pack(ATTRIBUTES.get(tokenType))
    }
}