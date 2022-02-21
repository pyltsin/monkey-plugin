package com.github.pyltsin.monkeyplugin.refactor

import com.github.pyltsin.monkeyplugin.MonkeyCodeInsightFixtureTestCase

class RenameTest : MonkeyCodeInsightFixtureTestCase() {
    override fun getBasePath(): String {
        return "refactor"
    }

    fun testRename() {
        myFixture.configureByFiles("RenameTestData.monkey")
        myFixture.renameElementAtCaret("test")
        myFixture.checkResultByFile("RenameTestData.monkey", "RenameTestDataAfter.monkey", false)
    }
}
