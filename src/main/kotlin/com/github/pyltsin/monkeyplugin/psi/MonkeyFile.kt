package com.github.pyltsin.monkeyplugin.psi

import com.github.pyltsin.monkeyplugin.MonkeyFileType
import com.github.pyltsin.monkeyplugin.MonkeyLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class MonkeyFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, MonkeyLanguage.INSTANCE) {
    override fun getFileType(): FileType {
        return MonkeyFileType.INSTANCE
    }

    override fun toString(): String {
        return "MonkeyFile"
    }
}