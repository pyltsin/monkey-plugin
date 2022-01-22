// This is a generated file. Not intended for manual editing.
package com.github.pyltsin.monkeyplugin;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.pyltsin.monkeyplugin.psi.impl.*;

public interface MonkeyTypes {

  IElementType ARGUMENT = new MonkeyElementType("ARGUMENT");
  IElementType ARGUMENTS = new MonkeyElementType("ARGUMENTS");
  IElementType ARRAY_EXPR = new MonkeyElementType("ARRAY_EXPR");
  IElementType BLOCK_STATE = new MonkeyElementType("BLOCK_STATE");
  IElementType BOOL_LITERAL = new MonkeyElementType("BOOL_LITERAL");
  IElementType CALL_ARGUMENTS = new MonkeyElementType("CALL_ARGUMENTS");
  IElementType DIV_EXPR = new MonkeyElementType("DIV_EXPR");
  IElementType ELSE_BLOCK = new MonkeyElementType("ELSE_BLOCK");
  IElementType EQUAL_EXPR = new MonkeyElementType("EQUAL_EXPR");
  IElementType EXPR = new MonkeyElementType("EXPR");
  IElementType FUNC_CALL_EXPR = new MonkeyElementType("FUNC_CALL_EXPR");
  IElementType FUNC_EXPR = new MonkeyElementType("FUNC_EXPR");
  IElementType IDENTIFIER_CALL_EXPR = new MonkeyElementType("IDENTIFIER_CALL_EXPR");
  IElementType IF_COND = new MonkeyElementType("IF_COND");
  IElementType IF_EXPR = new MonkeyElementType("IF_EXPR");
  IElementType INDEX_EXPR = new MonkeyElementType("INDEX_EXPR");
  IElementType INTEGRAL_LITERAL = new MonkeyElementType("INTEGRAL_LITERAL");
  IElementType LESS_EXPR = new MonkeyElementType("LESS_EXPR");
  IElementType LET_STATEMENT = new MonkeyElementType("LET_STATEMENT");
  IElementType LITERAL_EXPR = new MonkeyElementType("LITERAL_EXPR");
  IElementType MAP_ARGUMENTS = new MonkeyElementType("MAP_ARGUMENTS");
  IElementType MAP_EXPR = new MonkeyElementType("MAP_EXPR");
  IElementType MINUS_EXPR = new MonkeyElementType("MINUS_EXPR");
  IElementType MORE_EXPR = new MonkeyElementType("MORE_EXPR");
  IElementType MUL_EXPR = new MonkeyElementType("MUL_EXPR");
  IElementType NOT_EQUAL_EXPR = new MonkeyElementType("NOT_EQUAL_EXPR");
  IElementType NUMERIC_LITERAL = new MonkeyElementType("NUMERIC_LITERAL");
  IElementType PARAM_GROUP = new MonkeyElementType("PARAM_GROUP");
  IElementType PAREN_EXPR = new MonkeyElementType("PAREN_EXPR");
  IElementType PLUS_EXPR = new MonkeyElementType("PLUS_EXPR");
  IElementType RETURN_STATEMENT = new MonkeyElementType("RETURN_STATEMENT");
  IElementType SIMPLE_REF_EXPR = new MonkeyElementType("SIMPLE_REF_EXPR");
  IElementType STATEMENT = new MonkeyElementType("STATEMENT");
  IElementType STRING_LITERAL = new MonkeyElementType("STRING_LITERAL");
  IElementType UNARY_MIN_EXPR = new MonkeyElementType("UNARY_MIN_EXPR");
  IElementType UNARY_NOT_EXPR = new MonkeyElementType("UNARY_NOT_EXPR");
  IElementType UNUSED_IN_BNF = new MonkeyElementType("UNUSED_IN_BNF");

  IElementType ASSIGN = new MonkeyTokenType("=");
  IElementType ASTERISK = new MonkeyTokenType("*");
  IElementType BAD_CHARACTER = new MonkeyTokenType("BAD_CHARACTER");
  IElementType BANG = new MonkeyTokenType("!");
  IElementType COLON = new MonkeyTokenType(":");
  IElementType COMMA = new MonkeyTokenType(",");
  IElementType ELSE = new MonkeyTokenType("else");
  IElementType EQ = new MonkeyTokenType("==");
  IElementType FALSE = new MonkeyTokenType("false");
  IElementType FUNCTION = new MonkeyTokenType("fn");
  IElementType GT = new MonkeyTokenType(">");
  IElementType IDENT = new MonkeyTokenType("IDENT");
  IElementType IF = new MonkeyTokenType("if");
  IElementType INT = new MonkeyTokenType("INT");
  IElementType LBRACE = new MonkeyTokenType("{");
  IElementType LBRACKET = new MonkeyTokenType("[");
  IElementType LET = new MonkeyTokenType("let");
  IElementType LPAREN = new MonkeyTokenType("(");
  IElementType LT = new MonkeyTokenType("<");
  IElementType MINUS = new MonkeyTokenType("-");
  IElementType NEW_LINE = new MonkeyTokenType("NEW_LINE");
  IElementType NOT_EQ = new MonkeyTokenType("!=");
  IElementType PLUS = new MonkeyTokenType("+");
  IElementType RBRACE = new MonkeyTokenType("}");
  IElementType RBRACKET = new MonkeyTokenType("]");
  IElementType RETURN = new MonkeyTokenType("return");
  IElementType RPAREN = new MonkeyTokenType(")");
  IElementType SEMICOLON = new MonkeyTokenType(";");
  IElementType SLASH = new MonkeyTokenType("/");
  IElementType STRING = new MonkeyTokenType("STRING");
  IElementType TRUE = new MonkeyTokenType("true");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARGUMENT) {
        return new MonkeyArgumentImpl(node);
      }
      else if (type == ARGUMENTS) {
        return new MonkeyArgumentsImpl(node);
      }
      else if (type == ARRAY_EXPR) {
        return new MonkeyArrayExprImpl(node);
      }
      else if (type == BLOCK_STATE) {
        return new MonkeyBlockStateImpl(node);
      }
      else if (type == BOOL_LITERAL) {
        return new MonkeyBoolLiteralImpl(node);
      }
      else if (type == CALL_ARGUMENTS) {
        return new MonkeyCallArgumentsImpl(node);
      }
      else if (type == DIV_EXPR) {
        return new MonkeyDivExprImpl(node);
      }
      else if (type == ELSE_BLOCK) {
        return new MonkeyElseBlockImpl(node);
      }
      else if (type == EQUAL_EXPR) {
        return new MonkeyEqualExprImpl(node);
      }
      else if (type == FUNC_CALL_EXPR) {
        return new MonkeyFuncCallExprImpl(node);
      }
      else if (type == FUNC_EXPR) {
        return new MonkeyFuncExprImpl(node);
      }
      else if (type == IDENTIFIER_CALL_EXPR) {
        return new MonkeyIdentifierCallExprImpl(node);
      }
      else if (type == IF_COND) {
        return new MonkeyIfCondImpl(node);
      }
      else if (type == IF_EXPR) {
        return new MonkeyIfExprImpl(node);
      }
      else if (type == INDEX_EXPR) {
        return new MonkeyIndexExprImpl(node);
      }
      else if (type == INTEGRAL_LITERAL) {
        return new MonkeyIntegralLiteralImpl(node);
      }
      else if (type == LESS_EXPR) {
        return new MonkeyLessExprImpl(node);
      }
      else if (type == LET_STATEMENT) {
        return new MonkeyLetStatementImpl(node);
      }
      else if (type == LITERAL_EXPR) {
        return new MonkeyLiteralExprImpl(node);
      }
      else if (type == MAP_ARGUMENTS) {
        return new MonkeyMapArgumentsImpl(node);
      }
      else if (type == MAP_EXPR) {
        return new MonkeyMapExprImpl(node);
      }
      else if (type == MINUS_EXPR) {
        return new MonkeyMinusExprImpl(node);
      }
      else if (type == MORE_EXPR) {
        return new MonkeyMoreExprImpl(node);
      }
      else if (type == MUL_EXPR) {
        return new MonkeyMulExprImpl(node);
      }
      else if (type == NOT_EQUAL_EXPR) {
        return new MonkeyNotEqualExprImpl(node);
      }
      else if (type == NUMERIC_LITERAL) {
        return new MonkeyNumericLiteralImpl(node);
      }
      else if (type == PARAM_GROUP) {
        return new MonkeyParamGroupImpl(node);
      }
      else if (type == PAREN_EXPR) {
        return new MonkeyParenExprImpl(node);
      }
      else if (type == PLUS_EXPR) {
        return new MonkeyPlusExprImpl(node);
      }
      else if (type == RETURN_STATEMENT) {
        return new MonkeyReturnStatementImpl(node);
      }
      else if (type == SIMPLE_REF_EXPR) {
        return new MonkeySimpleRefExprImpl(node);
      }
      else if (type == STATEMENT) {
        return new MonkeyStatementImpl(node);
      }
      else if (type == STRING_LITERAL) {
        return new MonkeyStringLiteralImpl(node);
      }
      else if (type == UNARY_MIN_EXPR) {
        return new MonkeyUnaryMinExprImpl(node);
      }
      else if (type == UNARY_NOT_EXPR) {
        return new MonkeyUnaryNotExprImpl(node);
      }
      else if (type == UNUSED_IN_BNF) {
        return new MonkeyUnusedInBnfImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
