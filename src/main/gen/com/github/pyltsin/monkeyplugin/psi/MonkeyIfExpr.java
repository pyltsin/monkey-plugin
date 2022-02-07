// This is a generated file. Not intended for manual editing.
package com.github.pyltsin.monkeyplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MonkeyIfExpr extends MonkeyExpr {

  @Nullable
  MonkeyBlockState getBlockState();

  @Nullable
  MonkeyElseBlock getElseBlock();

  @Nullable
  MonkeyIfCond getIfCond();

  @NotNull
  PsiElement getIf();

  @Nullable
  PsiElement getLbrace();

  @Nullable
  PsiElement getRbrace();

}
