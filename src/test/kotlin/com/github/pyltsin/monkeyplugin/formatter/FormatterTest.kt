package com.github.pyltsin.monkeyplugin.formatter

import com.github.pyltsin.monkeyplugin.MonkeyCodeInsightFixtureTestCase
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.psi.codeStyle.CodeStyleManager
import com.intellij.util.containers.ContainerUtil


class FormatterTest : MonkeyCodeInsightFixtureTestCase() {
    override fun getBasePath(): String {
        return "formatter"
    }

    fun testFormatter() {
        myFixture.configureByFile("FormatterTestData.monkey")
        WriteCommandAction.writeCommandAction(project).run<RuntimeException> {
            CodeStyleManager.getInstance(project).reformatText(
                myFixture.file,
                ContainerUtil.newArrayList(myFixture.file.textRange)
            )
        }
        myFixture.checkResultByFile("DefaultTestData.monkey")
    }
}
