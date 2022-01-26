package com.github.pyltsin.monkeyplugin.formatter

import com.github.pyltsin.monkeyplugin.MonkeyLanguage
import com.github.pyltsin.monkeyplugin.MonkeyTypes
import com.intellij.formatting.*
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.formatter.common.AbstractBlock

class MonkeyFormattingModelBuilder : FormattingModelBuilder {
    companion object {
        private fun createSpacingBuilder(settings: CodeStyleSettings): SpacingBuilder {
            return SpacingBuilder(settings, MonkeyLanguage.INSTANCE)
                .before(MonkeyTypes.COMMA).spaceIf(false)
                .after(MonkeyTypes.COMMA).spaceIf(true)
                .before(MonkeyTypes.SEMICOLON).spaceIf(false)
                .after(MonkeyTypes.SEMICOLON).lineBreakInCode()
                .after(MonkeyTypes.LET).spaces(1)
                .around(MonkeyTypes.ASSIGN).spaces(1)
                .around(MonkeyTypes.PLUS).spaces(1)
                .around(MonkeyTypes.MINUS).spaces(1)
                .around(MonkeyTypes.ASTERISK).spaces(1)
                .around(MonkeyTypes.SLASH).spaces(1)
                .after(MonkeyTypes.FUNCTION).none()
                .around(MonkeyTypes.PARAM_GROUP).none()
                .after(MonkeyTypes.LBRACE).lineBreakInCode()
                .after(MonkeyTypes.RETURN).spaces(1)
                .before(MonkeyTypes.LBRACE).none()
                .around(MonkeyTypes.RBRACE).lineBreakInCode()
        }
    }

    override fun createModel(context: FormattingContext): FormattingModel {
        val node = context.node
        val settings = context.codeStyleSettings
        val block: Block = MonkeyFormattingBlock(
            myNode = node,
            myAlignment = null,
            myIndent = Indent.getNoneIndent(),
            myWrap = null,
            mySettings = settings,
            mySpacingBuilder = createSpacingBuilder(settings)
        )

        return FormattingModelProvider.createFormattingModelForPsiFile(
            context.containingFile,
            block,
            settings
        )
    }

    override fun getRangeAffectingIndent(file: PsiFile, offset: Int, elementAtOffset: ASTNode): TextRange? {
        return null
    }

    private class MonkeyFormattingBlock(
        myNode: ASTNode,
        myAlignment: Alignment?,
        private val myIndent: Indent?,
        myWrap: Wrap?,
        private val mySettings: CodeStyleSettings,
        private val mySpacingBuilder: SpacingBuilder
    ) : AbstractBlock(myNode, myWrap, myAlignment) {

        override fun getIndent(): Indent? {
            return myIndent
        }

        override fun getAlignment(): Alignment? {
            return myAlignment
        }

        private fun calcIndent(child: ASTNode): Indent {
            val parentType = myNode.elementType
            val type = child.elementType
            if (type==MonkeyTypes.BLOCK_STATE) {
                return Indent.getNormalIndent(true)
            }
            return Indent.getNoneIndent()
        }

        override fun getSpacing(child1: Block?, child2: Block): Spacing? {
            return mySpacingBuilder.getSpacing(this, child1, child2)
        }

        override fun isLeaf(): Boolean {
            return myNode.firstChildNode == null
        }

        override fun buildChildren(): MutableList<Block> {
            val blocks: MutableList<Block> = arrayListOf()
            var child = myNode.firstChildNode
            while (child != null) {
                val childType = child.elementType
                if (child.textRange.length == 0) {
                    child = child.treeNext
                    continue
                }
                if (childType === TokenType.WHITE_SPACE) {
                    child = child.treeNext
                    continue
                }
                val indent = calcIndent(child)
                val e = MonkeyFormattingBlock(child, null, indent, null, mySettings, mySpacingBuilder)
                blocks.add(e)
                child = child.treeNext
            }
            return blocks
        }
    }
}
