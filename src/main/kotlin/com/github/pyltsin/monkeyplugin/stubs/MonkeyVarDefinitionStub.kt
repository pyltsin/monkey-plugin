package com.github.pyltsin.monkeyplugin.stubs

import com.github.pyltsin.monkeyplugin.psi.MonkeyLetExpr
import com.intellij.psi.stubs.IStubElementType
import com.intellij.psi.stubs.NamedStubBase
import com.intellij.psi.stubs.StubElement
import com.intellij.util.io.StringRef

class MonkeyVarDefinitionStub : NamedStubBase<MonkeyLetExpr> {
    constructor(parent: StubElement<*>?, elementType: IStubElementType<*, *>, name: StringRef?) : super(
        parent,
        elementType,
        name
    ) {
    }

    constructor(parent: StubElement<*>?, elementType: IStubElementType<*, *>, name: String?) : super(
        parent,
        elementType,
        name
    ) {
    }
}
