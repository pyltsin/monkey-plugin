package com.github.pyltsin.monkeyplugin.stubs

import com.github.pyltsin.monkeyplugin.psi.MonkeyFile
import com.intellij.psi.stubs.PsiFileStubImpl

class MonkeyFileStub(file: MonkeyFile?) : PsiFileStubImpl<MonkeyFile>(file)
