// This is a generated file. Not intended for manual editing.
package com.github.pyltsin.monkeyplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.StubBasedPsiElement;
import com.github.pyltsin.monkeyplugin.stubs.MonkeyLetExpressionStub;

public interface MonkeyLetExpr extends MonkeyNamedElement, StubBasedPsiElement<MonkeyLetExpressionStub> {

  @NotNull
  PsiElement getIdent();

  @Nullable
  PsiElement resolve();

}
