package com.github.pyltsin.monkeyplugin.completion

import com.intellij.codeInsight.completion.CompletionParameters
import com.intellij.codeInsight.completion.CompletionProvider
import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.util.ProcessingContext

class MonkeyKeywordCompletionProvider(private val needSpace: Boolean, private val keywords: List<String>) :
    CompletionProvider<CompletionParameters>() {
    override fun addCompletions(
        parameters: CompletionParameters,
        context: ProcessingContext,
        result: CompletionResultSet
    ) {
        val nextSymbolIsSpace = isNextSymbolIsSpace(parameters)
        result.addAllElements(keywords.map { keyword ->
            val lookupString = if (!nextSymbolIsSpace && needSpace) "$keyword " else keyword
            LookupElementBuilder.create(lookupString)
        })
    }

    private fun isNextSymbolIsSpace(parameters: CompletionParameters): Boolean {
        val editor = parameters.editor
        val offset = editor.caretModel.primaryCaret.offset
        val document = editor.document
        return if (offset < document.textLength) document.text[offset] == ' ' else false
    }
}
