// This is a generated file. Not intended for manual editing.
package com.github.pyltsin.monkeyplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MonkeyIndexExpr extends MonkeyExpr {

  @NotNull
  List<MonkeyExpr> getExprList();

  @NotNull
  PsiElement getLbracket();

  @Nullable
  PsiElement getRbracket();

}
