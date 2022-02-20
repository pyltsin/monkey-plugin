package com.github.pyltsin.monkeyplugin.parser

import com.intellij.testFramework.ParsingTestCase

class ParsingTest : ParsingTestCase("", "monkey", MonkeyParserDefinition()) {
    override fun includeRanges(): Boolean {
        return true
    }

    fun testParsingTestData() {
        doTest(true)
    }

    override fun skipSpaces(): Boolean {
        return false
    }

    override fun getTestDataPath(): String {
        return "src/test/testData/parser"
    }
}
