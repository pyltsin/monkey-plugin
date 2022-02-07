// This is a generated file. Not intended for manual editing.
package com.github.pyltsin.monkeyplugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.pyltsin.monkeyplugin.MonkeyTypes.*;
import com.github.pyltsin.monkeyplugin.psi.*;

public class MonkeyLiteralExprImpl extends MonkeyExprImpl implements MonkeyLiteralExpr {

  public MonkeyLiteralExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull MonkeyVisitor visitor) {
    visitor.visitLiteralExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MonkeyVisitor) accept((MonkeyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public MonkeyBoolLiteral getBoolLiteral() {
    return PsiTreeUtil.getChildOfType(this, MonkeyBoolLiteral.class);
  }

  @Override
  @Nullable
  public MonkeyNumericLiteral getNumericLiteral() {
    return PsiTreeUtil.getChildOfType(this, MonkeyNumericLiteral.class);
  }

  @Override
  @Nullable
  public MonkeyStringLiteral getStringLiteral() {
    return PsiTreeUtil.getChildOfType(this, MonkeyStringLiteral.class);
  }

}
