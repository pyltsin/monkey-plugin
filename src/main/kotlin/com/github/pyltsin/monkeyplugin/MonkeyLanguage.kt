package com.github.pyltsin.monkeyplugin

import com.intellij.lang.Language

class MonkeyLanguage : Language("Monkey") {
    companion object {
        @JvmStatic
        val INSTANCE = MonkeyLanguage()
    }
}