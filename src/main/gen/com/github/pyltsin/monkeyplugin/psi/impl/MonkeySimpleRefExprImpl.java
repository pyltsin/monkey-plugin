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

public class MonkeySimpleRefExprImpl extends MonkeyExprImpl implements MonkeySimpleRefExpr {

  public MonkeySimpleRefExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull MonkeyVisitor visitor) {
    visitor.visitSimpleRefExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof MonkeyVisitor) accept((MonkeyVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getIdent() {
    return notNullChild(findChildByType(IDENT));
  }

  @Override
  @NotNull
  public MonkeyReferenceBase getReference() {
    return MonkeyPsiImplUtil.getReference(this);
  }

  @Override
  @Nullable
  public PsiElement resolve() {
    return MonkeyPsiImplUtil.resolve(this);
  }

}
