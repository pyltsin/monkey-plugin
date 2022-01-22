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

public class MonkeyIfExprImpl extends MonkeyExprImpl implements MonkeyIfExpr {

  public MonkeyIfExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull MonkeyVisitor visitor) {
    visitor.visitIfExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MonkeyVisitor) accept((MonkeyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public MonkeyBlockState getBlockState() {
    return findChildByClass(MonkeyBlockState.class);
  }

  @Override
  @Nullable
  public MonkeyElseBlock getElseBlock() {
    return findChildByClass(MonkeyElseBlock.class);
  }

  @Override
  @Nullable
  public MonkeyIfCond getIfCond() {
    return findChildByClass(MonkeyIfCond.class);
  }

}
