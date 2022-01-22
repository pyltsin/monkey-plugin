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

public class MonkeyIdentifierCallExprImpl extends MonkeyExprImpl implements MonkeyIdentifierCallExpr {

  public MonkeyIdentifierCallExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull MonkeyVisitor visitor) {
    visitor.visitIdentifierCallExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MonkeyVisitor) accept((MonkeyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public MonkeyCallArguments getCallArguments() {
    return findNotNullChildByClass(MonkeyCallArguments.class);
  }

  @Override
  @NotNull
  public MonkeySimpleRefExpr getSimpleRefExpr() {
    return findNotNullChildByClass(MonkeySimpleRefExpr.class);
  }

}
