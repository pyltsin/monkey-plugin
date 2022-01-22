package com.github.pyltsin.monkeyplugin.parser

import com.github.pyltsin.monkeyplugin.MonkeyLanguage
import com.github.pyltsin.monkeyplugin.MonkeyTypes
import com.github.pyltsin.monkeyplugin.lexer.MonkeyFlexAdapter
import com.github.pyltsin.monkeyplugin.psi.MonkeyFile
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType.WHITE_SPACE
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class MonkeyParserDefinition() : ParserDefinition {

    companion object {
        @JvmStatic
        val FILE = IFileElementType(MonkeyLanguage.INSTANCE)

        @JvmStatic
        val STRINGS = TokenSet.create(MonkeyTypes.STRING)

        @JvmStatic
        val WHITE_SPACES = TokenSet.create(MonkeyTypes.NEW_LINE, WHITE_SPACE)
    }

    override fun createLexer(project: Project?): Lexer {
        return MonkeyFlexAdapter()
    }

    override fun createParser(project: Project?): PsiParser {
        return MonkeyParser()
    }

    override fun getFileNodeType(): IFileElementType {
        //todo исправить для stub
        return FILE
    }

    override fun getCommentTokens(): TokenSet {
        //todo исправить для комментаривем
        return TokenSet.EMPTY
    }

    override fun getStringLiteralElements(): TokenSet {
        return STRINGS
    }

    override fun createElement(node: ASTNode?): PsiElement {
        return MonkeyTypes.Factory.createElement(node)
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return MonkeyFile(viewProvider)
    }

    override fun spaceExistenceTypeBetweenTokens(left: ASTNode?, right: ASTNode?): ParserDefinition.SpaceRequirements {
        return ParserDefinition.SpaceRequirements.MAY
    }

    override fun getWhitespaceTokens(): TokenSet {
        return WHITE_SPACES
    }
}