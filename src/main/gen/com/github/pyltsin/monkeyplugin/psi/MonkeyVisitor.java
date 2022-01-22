// This is a generated file. Not intended for manual editing.
package com.github.pyltsin.monkeyplugin.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class MonkeyVisitor extends PsiElementVisitor {

  public void visitArgument(@NotNull MonkeyArgument o) {
    visitPsiElement(o);
  }

  public void visitArguments(@NotNull MonkeyArguments o) {
    visitPsiElement(o);
  }

  public void visitArrayExpr(@NotNull MonkeyArrayExpr o) {
    visitExpr(o);
  }

  public void visitBlockState(@NotNull MonkeyBlockState o) {
    visitPsiElement(o);
  }

  public void visitBoolLiteral(@NotNull MonkeyBoolLiteral o) {
    visitPsiElement(o);
  }

  public void visitCallArguments(@NotNull MonkeyCallArguments o) {
    visitPsiElement(o);
  }

  public void visitDivExpr(@NotNull MonkeyDivExpr o) {
    visitExpr(o);
  }

  public void visitElseBlock(@NotNull MonkeyElseBlock o) {
    visitPsiElement(o);
  }

  public void visitEqualExpr(@NotNull MonkeyEqualExpr o) {
    visitExpr(o);
  }

  public void visitExpr(@NotNull MonkeyExpr o) {
    visitPsiElement(o);
  }

  public void visitFuncCallExpr(@NotNull MonkeyFuncCallExpr o) {
    visitExpr(o);
  }

  public void visitFuncExpr(@NotNull MonkeyFuncExpr o) {
    visitExpr(o);
  }

  public void visitIdentifierCallExpr(@NotNull MonkeyIdentifierCallExpr o) {
    visitExpr(o);
  }

  public void visitIfCond(@NotNull MonkeyIfCond o) {
    visitPsiElement(o);
  }

  public void visitIfExpr(@NotNull MonkeyIfExpr o) {
    visitExpr(o);
  }

  public void visitIndexExpr(@NotNull MonkeyIndexExpr o) {
    visitExpr(o);
  }

  public void visitIntegralLiteral(@NotNull MonkeyIntegralLiteral o) {
    visitPsiElement(o);
  }

  public void visitLessExpr(@NotNull MonkeyLessExpr o) {
    visitExpr(o);
  }

  public void visitLetStatement(@NotNull MonkeyLetStatement o) {
    visitPsiElement(o);
  }

  public void visitLiteralExpr(@NotNull MonkeyLiteralExpr o) {
    visitExpr(o);
  }

  public void visitMapArguments(@NotNull MonkeyMapArguments o) {
    visitPsiElement(o);
  }

  public void visitMapExpr(@NotNull MonkeyMapExpr o) {
    visitExpr(o);
  }

  public void visitMinusExpr(@NotNull MonkeyMinusExpr o) {
    visitExpr(o);
  }

  public void visitMoreExpr(@NotNull MonkeyMoreExpr o) {
    visitExpr(o);
  }

  public void visitMulExpr(@NotNull MonkeyMulExpr o) {
    visitExpr(o);
  }

  public void visitNotEqualExpr(@NotNull MonkeyNotEqualExpr o) {
    visitExpr(o);
  }

  public void visitNumericLiteral(@NotNull MonkeyNumericLiteral o) {
    visitPsiElement(o);
  }

  public void visitParamGroup(@NotNull MonkeyParamGroup o) {
    visitPsiElement(o);
  }

  public void visitParenExpr(@NotNull MonkeyParenExpr o) {
    visitExpr(o);
  }

  public void visitPlusExpr(@NotNull MonkeyPlusExpr o) {
    visitExpr(o);
  }

  public void visitReturnStatement(@NotNull MonkeyReturnStatement o) {
    visitPsiElement(o);
  }

  public void visitSimpleRefExpr(@NotNull MonkeySimpleRefExpr o) {
    visitExpr(o);
  }

  public void visitStatement(@NotNull MonkeyStatement o) {
    visitPsiElement(o);
  }

  public void visitStringLiteral(@NotNull MonkeyStringLiteral o) {
    visitPsiElement(o);
  }

  public void visitUnaryMinExpr(@NotNull MonkeyUnaryMinExpr o) {
    visitExpr(o);
  }

  public void visitUnaryNotExpr(@NotNull MonkeyUnaryNotExpr o) {
    visitExpr(o);
  }

  public void visitUnusedInBnf(@NotNull MonkeyUnusedInBnf o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
