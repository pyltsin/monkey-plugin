package com.github.pyltsin.monkeyplugin.annotator

import com.github.pyltsin.monkeyplugin.MonkeyCodeInsightFixtureTestCase

class WarningAnnotator : MonkeyCodeInsightFixtureTestCase() {
    override fun getBasePath(): String {
        return "annotator"
    }

    fun testWarning() {
        myFixture.configureByFiles("AnnotatorTest.monkey")
        myFixture.checkHighlighting(true, true,
            true, false)
    }
}
