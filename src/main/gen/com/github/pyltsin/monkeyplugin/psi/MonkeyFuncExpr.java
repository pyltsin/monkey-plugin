// This is a generated file. Not intended for manual editing.
package com.github.pyltsin.monkeyplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MonkeyFuncExpr extends MonkeyExpr {

  @Nullable
  MonkeyBlockState getBlockState();

  @Nullable
  MonkeyParamGroup getParamGroup();

  @NotNull
  PsiElement getFunction();

  @Nullable
  PsiElement getLbrace();

  @Nullable
  PsiElement getLparen();

  @Nullable
  PsiElement getRbrace();

  @Nullable
  PsiElement getRparen();

}
