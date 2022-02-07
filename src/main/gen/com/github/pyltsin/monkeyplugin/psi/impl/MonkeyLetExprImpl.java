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
import com.github.pyltsin.monkeyplugin.stubs.MonkeyLetExpressionStub;
import com.intellij.psi.stubs.IStubElementType;

public class MonkeyLetExprImpl extends MonkeyLetExpressionBaseImpl implements MonkeyLetExpr {

  public MonkeyLetExprImpl(@NotNull MonkeyLetExpressionStub stub, @NotNull IStubElementType<?, ?> type) {
    super(stub, type);
  }

  public MonkeyLetExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull MonkeyVisitor visitor) {
    visitor.visitLetExpr(this);
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
  @Nullable
  public PsiElement resolve() {
    return MonkeyPsiImplUtil.resolve(this);
  }

}
