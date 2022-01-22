package com.github.pyltsin.monkeyplugin

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class MonkeyFileType : LanguageFileType(MonkeyLanguage.INSTANCE) {
    override fun getName(): String {
        return "Monkey File"
    }

    override fun getDescription(): String {
        return "Monkey language file"
    }

    override fun getDefaultExtension(): String {
        return "monkey"
    }

    override fun getIcon(): Icon {
        return MonkeyIcons.FILE
    }

    companion object {
        @JvmStatic
        val INSTANCE = MonkeyFileType()
    }
}