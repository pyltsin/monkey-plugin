// This is a generated file. Not intended for manual editing.
package com.github.pyltsin.monkeyplugin.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.StubBasedPsiElement;
import com.github.pyltsin.monkeyplugin.stubs.MonkeyVarDefinitionStub;

public interface MonkeyLetExpr extends MonkeyNamedElement, StubBasedPsiElement<MonkeyVarDefinitionStub> {

  @NotNull
  PsiElement getIdent();

  @Nullable
  PsiElement resolve();

}
