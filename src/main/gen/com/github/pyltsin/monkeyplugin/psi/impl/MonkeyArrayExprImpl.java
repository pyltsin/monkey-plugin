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

public class MonkeyArrayExprImpl extends MonkeyExprImpl implements MonkeyArrayExpr {

  public MonkeyArrayExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull MonkeyVisitor visitor) {
    visitor.visitArrayExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MonkeyVisitor) accept((MonkeyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public MonkeyArguments getArguments() {
    return PsiTreeUtil.getChildOfType(this, MonkeyArguments.class);
  }

  @Override
  @NotNull
  public PsiElement getLbracket() {
    return notNullChild(findChildByType(LBRACKET));
  }

  @Override
  @Nullable
  public PsiElement getRbracket() {
    return findChildByType(RBRACKET);
  }

}
