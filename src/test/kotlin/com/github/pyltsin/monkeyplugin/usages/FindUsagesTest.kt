package com.github.pyltsin.monkeyplugin.usages

import com.github.pyltsin.monkeyplugin.MonkeyCodeInsightFixtureTestCase
import com.github.pyltsin.monkeyplugin.psi.MonkeyLetStatement
import com.github.pyltsin.monkeyplugin.psi.MonkeyVarDefinition


class FindUsagesTest : MonkeyCodeInsightFixtureTestCase() {
    override fun getBasePath(): String {
        return "usages"
    }

    fun testFindUsages() {
        val usageInfos = myFixture.testFindUsages("FindUsagesTestData.monkey")
        assertEquals(1, usageInfos.size)
    }

    fun testReference() {
        val referenceAtCaret =
            myFixture.getReferenceAtCaretPositionWithAssertion("ReferenceTestData.monkey")
        val resolvedReference = assertInstanceOf(
            referenceAtCaret.resolve(),
            MonkeyVarDefinition::class.java
        )
        assertTrue((resolvedReference.parent as? MonkeyLetStatement)?.expr?.textMatches("10")==true)
    }
}
