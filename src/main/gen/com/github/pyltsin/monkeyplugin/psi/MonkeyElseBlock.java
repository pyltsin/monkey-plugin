// This is a generated file. Not intended for manual editing.
package com.github.pyltsin.monkeyplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MonkeyElseBlock extends MonkeyCompositeElement {

  @Nullable
  MonkeyBlockState getBlockState();

  @NotNull
  PsiElement getElse();

  @Nullable
  PsiElement getLbrace();

  @Nullable
  PsiElement getRbrace();

}
