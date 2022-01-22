// This is a generated file. Not intended for manual editing.
package com.github.pyltsin.monkeyplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface MonkeyStatement extends PsiElement {

  @Nullable
  MonkeyExpr getExpr();

  @Nullable
  MonkeyLetStatement getLetStatement();

  @Nullable
  MonkeyReturnStatement getReturnStatement();

}
