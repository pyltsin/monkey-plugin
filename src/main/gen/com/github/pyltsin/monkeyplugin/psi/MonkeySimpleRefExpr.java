// This is a generated file. Not intended for manual editing.
package com.github.pyltsin.monkeyplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.github.pyltsin.monkeyplugin.psi.impl.MonkeyReferenceBase;

public interface MonkeySimpleRefExpr extends MonkeyExpr {

  @NotNull
  PsiElement getIdent();

  @NotNull
  MonkeyReferenceBase getReference();

  @Nullable
  PsiElement resolve();

  @NotNull
  PsiElement setName(@NotNull String name);

}
