package com.github.pyltsin.monkeyplugin.highlighter

import com.github.pyltsin.monkeyplugin.MonkeyIcons
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import javax.swing.Icon

class MonkeyColorSettingsPage : ColorSettingsPage {
    private val DESCRIPTORS = arrayOf(
        AttributesDescriptor("Keyword", MonkeySyntaxHighlighter.KEYWORDS),
        AttributesDescriptor("Number", MonkeySyntaxHighlighter.NUMBER),
        AttributesDescriptor("String", MonkeySyntaxHighlighter.STRING),
        AttributesDescriptor("Brackets", MonkeySyntaxHighlighter.BRACKETS),
        AttributesDescriptor("Operator", MonkeySyntaxHighlighter.OPERATORS),
        AttributesDescriptor("Bad value", MonkeySyntaxHighlighter.BAD_CHARACTER)
    )

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return DESCRIPTORS
    }

    override fun getColorDescriptors(): Array<ColorDescriptor> {
        return ColorDescriptor.EMPTY_ARRAY
    }

    override fun getDisplayName(): String {
        return "Monkey"
    }

    override fun getIcon(): Icon? {
        return MonkeyIcons.FILE;
    }

    override fun getHighlighter(): SyntaxHighlighter {
        return MonkeySyntaxHighlighter();
    }

    override fun getDemoText(): String {
        return """
            let f = fn(x) {
               let result = x + 10;
               return result;
               return 10;
            };
            print(f(10));
            asd;
        """.trimIndent()
    }

    override fun getAdditionalHighlightingTagToDescriptorMap(): MutableMap<String, TextAttributesKey>? {
        return null
    }

}