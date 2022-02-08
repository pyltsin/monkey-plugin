// This is a generated file. Not intended for manual editing.
package com.github.pyltsin.monkeyplugin.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;

public class MonkeyVisitor extends PsiElementVisitor {

  public void visitBinaryExpr(@NotNull MonkeyBinaryExpr o) {
    visitCompositeElement(o);
  }

  public void visitAll(@NotNull MonkeyAll o) {
    visitCompositeElement(o);
  }

  public void visitArgument(@NotNull MonkeyArgument o) {
    visitCompositeElement(o);
  }

  public void visitArguments(@NotNull MonkeyArguments o) {
    visitCompositeElement(o);
  }

  public void visitArrayExpr(@NotNull MonkeyArrayExpr o) {
    visitExpr(o);
  }

  public void visitBlockState(@NotNull MonkeyBlockState o) {
    visitCompositeElement(o);
  }

  public void visitBoolLiteral(@NotNull MonkeyBoolLiteral o) {
    visitCompositeElement(o);
  }

  public void visitCallArguments(@NotNull MonkeyCallArguments o) {
    visitCompositeElement(o);
  }

  public void visitCallExpr(@NotNull MonkeyCallExpr o) {
    visitExpr(o);
  }

  public void visitDivExpr(@NotNull MonkeyDivExpr o) {
    visitExpr(o);
  }

  public void visitElseBlock(@NotNull MonkeyElseBlock o) {
    visitCompositeElement(o);
  }

  public void visitEqualExpr(@NotNull MonkeyEqualExpr o) {
    visitExpr(o);
  }

  public void visitExpr(@NotNull MonkeyExpr o) {
    visitCompositeElement(o);
  }

  public void visitFuncExpr(@NotNull MonkeyFuncExpr o) {
    visitExpr(o);
  }

  public void visitIfCond(@NotNull MonkeyIfCond o) {
    visitCompositeElement(o);
  }

  public void visitIfExpr(@NotNull MonkeyIfExpr o) {
    visitExpr(o);
  }

  public void visitIndexExpr(@NotNull MonkeyIndexExpr o) {
    visitExpr(o);
  }

  public void visitIntegralLiteral(@NotNull MonkeyIntegralLiteral o) {
    visitCompositeElement(o);
  }

  public void visitLessExpr(@NotNull MonkeyLessExpr o) {
    visitExpr(o);
  }

  public void visitLetStatement(@NotNull MonkeyLetStatement o) {
    visitCompositeElement(o);
  }

  public void visitLiteralExpr(@NotNull MonkeyLiteralExpr o) {
    visitExpr(o);
  }

  public void visitMapArguments(@NotNull MonkeyMapArguments o) {
    visitCompositeElement(o);
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
    visitCompositeElement(o);
  }

  public void visitParamGroup(@NotNull MonkeyParamGroup o) {
    visitCompositeElement(o);
  }

  public void visitParenExpr(@NotNull MonkeyParenExpr o) {
    visitExpr(o);
  }

  public void visitPlusExpr(@NotNull MonkeyPlusExpr o) {
    visitExpr(o);
  }

  public void visitReturnStatement(@NotNull MonkeyReturnStatement o) {
    visitCompositeElement(o);
  }

  public void visitSimpleRefExpr(@NotNull MonkeySimpleRefExpr o) {
    visitExpr(o);
  }

  public void visitStatement(@NotNull MonkeyStatement o) {
    visitCompositeElement(o);
  }

  public void visitStringLiteral(@NotNull MonkeyStringLiteral o) {
    visitCompositeElement(o);
  }

  public void visitUnaryMinExpr(@NotNull MonkeyUnaryMinExpr o) {
    visitExpr(o);
  }

  public void visitUnaryNotExpr(@NotNull MonkeyUnaryNotExpr o) {
    visitExpr(o);
  }

  public void visitUnusedInBnf(@NotNull MonkeyUnusedInBnf o) {
    visitCompositeElement(o);
  }

  public void visitVarDefinition(@NotNull MonkeyVarDefinition o) {
    visitNamedElement(o);
  }

  public void visitNamedElement(@NotNull MonkeyNamedElement o) {
    visitCompositeElement(o);
  }

  public void visitCompositeElement(@NotNull MonkeyCompositeElement o) {
    visitElement(o);
  }

}
