package com.github.pyltsin.monkeyplugin

import com.intellij.testFramework.fixtures.BasePlatformTestCase
import java.io.File

abstract class MonkeyCodeInsightFixtureTestCase : BasePlatformTestCase() {
    override fun getTestDataPath(): String {
        return File("src/test/testData/$basePath").absolutePath
    }
}
