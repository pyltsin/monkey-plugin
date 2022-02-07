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

public class MonkeyStatementImpl extends ASTWrapperPsiElement implements MonkeyStatement {

  public MonkeyStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MonkeyVisitor visitor) {
    visitor.visitStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MonkeyVisitor) accept((MonkeyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public MonkeyExpr getExpr() {
    return PsiTreeUtil.getChildOfType(this, MonkeyExpr.class);
  }

  @Override
  @Nullable
  public MonkeyLetStatement getLetStatement() {
    return PsiTreeUtil.getChildOfType(this, MonkeyLetStatement.class);
  }

  @Override
  @Nullable
  public MonkeyReturnStatement getReturnStatement() {
    return PsiTreeUtil.getChildOfType(this, MonkeyReturnStatement.class);
  }

}
