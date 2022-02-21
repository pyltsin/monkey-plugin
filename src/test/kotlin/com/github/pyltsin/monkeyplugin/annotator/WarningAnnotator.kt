package com.github.pyltsin.monkeyplugin.annotator

import com.github.pyltsin.monkeyplugin.MonkeyCodeInsightFixtureTestCase
import com.intellij.codeInsight.completion.CompletionType

class WarningAnnotator : MonkeyCodeInsightFixtureTestCase() {
    override fun getBasePath(): String {
        return "annotator"
    }

    fun testWarning() {
        myFixture.configureByFiles("AnnotatorTest.monkey")
        myFixture.checkHighlighting(true, true,
            true, false);
    }
}
