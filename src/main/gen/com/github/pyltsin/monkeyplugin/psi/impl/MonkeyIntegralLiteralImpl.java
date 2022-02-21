// This is a generated file. Not intended for manual editing.
package com.github.pyltsin.monkeyplugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.pyltsin.monkeyplugin.MonkeyTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.pyltsin.monkeyplugin.psi.*;

public class MonkeyIntegralLiteralImpl extends ASTWrapperPsiElement implements MonkeyIntegralLiteral {

  public MonkeyIntegralLiteralImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MonkeyVisitor visitor) {
    visitor.visitIntegralLiteral(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MonkeyVisitor) accept((MonkeyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getInt() {
    return findNotNullChildByType(INT);
  }

}
