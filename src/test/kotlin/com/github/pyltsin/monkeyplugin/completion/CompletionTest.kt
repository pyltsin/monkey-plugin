package com.github.pyltsin.monkeyplugin.completion

import com.github.pyltsin.monkeyplugin.MonkeyCodeInsightFixtureTestCase
import com.intellij.codeInsight.completion.CompletionType


class CompletionTest : MonkeyCodeInsightFixtureTestCase() {
    override fun getBasePath(): String {
        return "completion"
    }

    fun testCompletion() {
        myFixture.configureByFiles("simple.monkey")
        myFixture.complete(CompletionType.BASIC)
        val lookupElementStrings: MutableList<String>? = myFixture.lookupElementStrings
        assertNotNull(lookupElementStrings)
        assertSameElements(lookupElementStrings!!, "let", "fn", "if", "f")
    }
}
