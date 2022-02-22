// This is a generated file. Not intended for manual editing.
package com.github.pyltsin.monkeyplugin.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.pyltsin.monkeyplugin.MonkeyTypes.*;
import static com.github.pyltsin.monkeyplugin.parser.MonkeyParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class MonkeyParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    boolean r;
    if (t == EXPR) {
      r = expr(b, l + 1, -1);
    }
    else {
      r = program(b, l + 1);
    }
    return r;
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(ARRAY_EXPR, CALL_EXPR, DIV_EXPR, EQUAL_EXPR,
      EXPR, FUNC_EXPR, IF_EXPR, INDEX_EXPR,
      LESS_EXPR, LITERAL_EXPR, MAP_EXPR, MINUS_EXPR,
      MORE_EXPR, MUL_EXPR, NOT_EQUAL_EXPR, PAREN_EXPR,
      PLUS_EXPR, SIMPLE_REF_EXPR, UNARY_MIN_EXPR, UNARY_NOT_EXPR),
  };

  /* ********************************************************** */
  // element *
  public static boolean all(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "all")) return false;
    Marker m = enter_section_(b, l, _NONE_, ALL, "<all>");
    while (true) {
      int c = current_position_(b);
      if (!element(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "all", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // expr
  public static boolean argument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argument")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENT, "<argument>");
    r = expr(b, l + 1, -1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // argument (COMMA argument)*
  public static boolean arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arguments")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENTS, "<arguments>");
    r = argument(b, l + 1);
    p = r; // pin = 1
    r = r && arguments_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (COMMA argument)*
  private static boolean arguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arguments_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!arguments_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "arguments_1", c)) break;
    }
    return true;
  }

  // COMMA argument
  private static boolean arguments_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arguments_1_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, COMMA);
    p = r; // pin = 1
    r = r && argument(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // element*
  public static boolean block_state(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_state")) return false;
    Marker m = enter_section_(b, l, _NONE_, BLOCK_STATE, "<block state>");
    while (true) {
      int c = current_position_(b);
      if (!element(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "block_state", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // TRUE | FALSE
  public static boolean boolLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "boolLiteral")) return false;
    if (!nextTokenIs(b, "<bool literal>", FALSE, TRUE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOL_LITERAL, "<bool literal>");
    r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LPAREN arguments? RPAREN
  public static boolean call_arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_arguments")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CALL_ARGUMENTS, null);
    r = consumeToken(b, LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, call_arguments_1(b, l + 1));
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // arguments?
  private static boolean call_arguments_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "call_arguments_1")) return false;
    arguments(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // !<<eof>> statement SEMICOLON
  static boolean element(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = element_0(b, l + 1);
    r = r && statement(b, l + 1);
    p = r; // pin = 2
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, p, MonkeyParser::property_recover);
    return r || p;
  }

  // !<<eof>>
  private static boolean element_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "element_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !eof(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ELSE LBRACE block_state RBRACE
  public static boolean else_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "else_block")) return false;
    if (!nextTokenIs(b, ELSE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ELSE_BLOCK, null);
    r = consumeTokens(b, 1, ELSE, LBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, block_state(b, l + 1));
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // LPAREN expr RPAREN
  public static boolean if_cond(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_cond")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, IF_COND, null);
    r = consumeToken(b, LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, expr(b, l + 1, -1));
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // INT
  public static boolean integralLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integralLiteral")) return false;
    if (!nextTokenIs(b, INT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INT);
    exit_section_(b, m, INTEGRAL_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // LET var_definition ASSIGN expr
  public static boolean let_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_statement")) return false;
    if (!nextTokenIs(b, LET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, LET_STATEMENT, null);
    r = consumeToken(b, LET);
    p = r; // pin = 1
    r = r && report_error_(b, var_definition(b, l + 1));
    r = p && report_error_(b, consumeToken(b, ASSIGN)) && r;
    r = p && expr(b, l + 1, -1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // expr COLON expr (COMMA expr COLON expr)*
  public static boolean map_arguments(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "map_arguments")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MAP_ARGUMENTS, "<map arguments>");
    r = expr(b, l + 1, -1);
    r = r && consumeToken(b, COLON);
    p = r; // pin = 2
    r = r && report_error_(b, expr(b, l + 1, -1));
    r = p && map_arguments_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (COMMA expr COLON expr)*
  private static boolean map_arguments_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "map_arguments_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!map_arguments_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "map_arguments_3", c)) break;
    }
    return true;
  }

  // COMMA expr COLON expr
  private static boolean map_arguments_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "map_arguments_3_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, COMMA);
    r = r && expr(b, l + 1, -1);
    p = r; // pin = 2
    r = r && report_error_(b, consumeToken(b, COLON));
    r = p && expr(b, l + 1, -1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // integralLiteral
  public static boolean numericLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "numericLiteral")) return false;
    if (!nextTokenIs(b, INT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = integralLiteral(b, l + 1);
    exit_section_(b, m, NUMERIC_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // var_definition (COMMA var_definition)*
  public static boolean param_group(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_group")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PARAM_GROUP, null);
    r = var_definition(b, l + 1);
    p = r; // pin = 1
    r = r && param_group_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (COMMA var_definition)*
  private static boolean param_group_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_group_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!param_group_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "param_group_1", c)) break;
    }
    return true;
  }

  // COMMA var_definition
  private static boolean param_group_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "param_group_1_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeToken(b, COMMA);
    p = r; // pin = 1
    r = r && var_definition(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // all
  static boolean program(PsiBuilder b, int l) {
    return all(b, l + 1);
  }

  /* ********************************************************** */
  // !( FUNCTION | LET | TRUE | FALSE |IF |ELSE |RETURN
  // | INT | STRING |IDENT | ASSIGN| PLUS | MINUS| BANG | ASTERISK |SLASH | LT |GT|EQ
  // | NOT_EQ | COMMA | COLON | LPAREN |RPAREN |LBRACE |RBRACE | LBRACKET | RBRACKET)
  static boolean property_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !property_recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // FUNCTION | LET | TRUE | FALSE |IF |ELSE |RETURN
  // | INT | STRING |IDENT | ASSIGN| PLUS | MINUS| BANG | ASTERISK |SLASH | LT |GT|EQ
  // | NOT_EQ | COMMA | COLON | LPAREN |RPAREN |LBRACE |RBRACE | LBRACKET | RBRACKET
  private static boolean property_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "property_recover_0")) return false;
    boolean r;
    r = consumeToken(b, FUNCTION);
    if (!r) r = consumeToken(b, LET);
    if (!r) r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    if (!r) r = consumeToken(b, IF);
    if (!r) r = consumeToken(b, ELSE);
    if (!r) r = consumeToken(b, RETURN);
    if (!r) r = consumeToken(b, INT);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, IDENT);
    if (!r) r = consumeToken(b, ASSIGN);
    if (!r) r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, BANG);
    if (!r) r = consumeToken(b, ASTERISK);
    if (!r) r = consumeToken(b, SLASH);
    if (!r) r = consumeToken(b, LT);
    if (!r) r = consumeToken(b, GT);
    if (!r) r = consumeToken(b, EQ);
    if (!r) r = consumeToken(b, NOT_EQ);
    if (!r) r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, LPAREN);
    if (!r) r = consumeToken(b, RPAREN);
    if (!r) r = consumeToken(b, LBRACE);
    if (!r) r = consumeToken(b, RBRACE);
    if (!r) r = consumeToken(b, LBRACKET);
    if (!r) r = consumeToken(b, RBRACKET);
    return r;
  }

  /* ********************************************************** */
  // RETURN expr
  public static boolean return_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "return_statement")) return false;
    if (!nextTokenIs(b, RETURN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RETURN_STATEMENT, null);
    r = consumeToken(b, RETURN);
    p = r; // pin = 1
    r = r && expr(b, l + 1, -1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // expr
  //             | let_statement
  //             | return_statement
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = expr(b, l + 1, -1);
    if (!r) r = let_statement(b, l + 1);
    if (!r) r = return_statement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // STRING
  public static boolean stringLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stringLiteral")) return false;
    if (!nextTokenIs(b, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    exit_section_(b, m, STRING_LITERAL, r);
    return r;
  }

  /* ********************************************************** */
  // BAD_CHARACTER
  //         | NEW_LINE
  public static boolean unusedInBnf(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unusedInBnf")) return false;
    if (!nextTokenIs(b, "<unused in bnf>", BAD_CHARACTER, NEW_LINE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNUSED_IN_BNF, "<unused in bnf>");
    r = consumeToken(b, BAD_CHARACTER);
    if (!r) r = consumeToken(b, NEW_LINE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENT
  public static boolean var_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_definition")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    exit_section_(b, m, VAR_DEFINITION, r);
    return r;
  }

  /* ********************************************************** */
  // Expression root: expr
  // Operator priority table:
  // 0: BINARY(equal_expr) BINARY(not_equal_expr)
  // 1: BINARY(less_expr) BINARY(more_expr)
  // 2: BINARY(plus_expr) BINARY(minus_expr)
  // 3: BINARY(mul_expr) BINARY(div_expr)
  // 4: ATOM(unary_min_expr) ATOM(unary_not_expr)
  // 5: ATOM(if_expr)
  // 6: POSTFIX(call_expr)
  // 7: BINARY(index_expr)
  // 8: ATOM(func_expr) ATOM(array_expr) ATOM(map_expr)
  // 9: ATOM(simple_ref_expr) ATOM(literal_expr) ATOM(paren_expr)
  public static boolean expr(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "expr")) return false;
    addVariant(b, "<expr>");
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, "<expr>");
    r = unary_min_expr(b, l + 1);
    if (!r) r = unary_not_expr(b, l + 1);
    if (!r) r = if_expr(b, l + 1);
    if (!r) r = func_expr(b, l + 1);
    if (!r) r = array_expr(b, l + 1);
    if (!r) r = map_expr(b, l + 1);
    if (!r) r = simple_ref_expr(b, l + 1);
    if (!r) r = literal_expr(b, l + 1);
    if (!r) r = paren_expr(b, l + 1);
    p = r;
    r = r && expr_0(b, l + 1, g);
    exit_section_(b, l, m, null, r, p, null);
    return r || p;
  }

  public static boolean expr_0(PsiBuilder b, int l, int g) {
    if (!recursion_guard_(b, l, "expr_0")) return false;
    boolean r = true;
    while (true) {
      Marker m = enter_section_(b, l, _LEFT_, null);
      if (g < 0 && consumeTokenSmart(b, EQ)) {
        r = expr(b, l, 0);
        exit_section_(b, l, m, EQUAL_EXPR, r, true, null);
      }
      else if (g < 0 && consumeTokenSmart(b, NOT_EQ)) {
        r = expr(b, l, 0);
        exit_section_(b, l, m, NOT_EQUAL_EXPR, r, true, null);
      }
      else if (g < 1 && consumeTokenSmart(b, LT)) {
        r = expr(b, l, 1);
        exit_section_(b, l, m, LESS_EXPR, r, true, null);
      }
      else if (g < 1 && consumeTokenSmart(b, GT)) {
        r = expr(b, l, 1);
        exit_section_(b, l, m, MORE_EXPR, r, true, null);
      }
      else if (g < 2 && consumeTokenSmart(b, PLUS)) {
        r = expr(b, l, 2);
        exit_section_(b, l, m, PLUS_EXPR, r, true, null);
      }
      else if (g < 2 && consumeTokenSmart(b, MINUS)) {
        r = expr(b, l, 2);
        exit_section_(b, l, m, MINUS_EXPR, r, true, null);
      }
      else if (g < 3 && consumeTokenSmart(b, ASTERISK)) {
        r = expr(b, l, 3);
        exit_section_(b, l, m, MUL_EXPR, r, true, null);
      }
      else if (g < 3 && consumeTokenSmart(b, SLASH)) {
        r = expr(b, l, 3);
        exit_section_(b, l, m, DIV_EXPR, r, true, null);
      }
      else if (g < 6 && call_arguments(b, l + 1)) {
        r = true;
        exit_section_(b, l, m, CALL_EXPR, r, true, null);
      }
      else if (g < 7 && consumeTokenSmart(b, LBRACKET)) {
        r = report_error_(b, expr(b, l, 7));
        r = consumeToken(b, RBRACKET) && r;
        exit_section_(b, l, m, INDEX_EXPR, r, true, null);
      }
      else {
        exit_section_(b, l, m, null, false, false, null);
        break;
      }
    }
    return r;
  }

  // MINUS expr
  public static boolean unary_min_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_min_expr")) return false;
    if (!nextTokenIsSmart(b, MINUS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, UNARY_MIN_EXPR, null);
    r = consumeTokenSmart(b, MINUS);
    p = r; // pin = 1
    r = r && expr(b, l + 1, -1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // BANG expr
  public static boolean unary_not_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unary_not_expr")) return false;
    if (!nextTokenIsSmart(b, BANG)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, UNARY_NOT_EXPR, null);
    r = consumeTokenSmart(b, BANG);
    p = r; // pin = 1
    r = r && expr(b, l + 1, -1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // IF if_cond LBRACE block_state RBRACE else_block?
  public static boolean if_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_expr")) return false;
    if (!nextTokenIsSmart(b, IF)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, IF_EXPR, null);
    r = consumeTokenSmart(b, IF);
    p = r; // pin = 1
    r = r && report_error_(b, if_cond(b, l + 1));
    r = p && report_error_(b, consumeToken(b, LBRACE)) && r;
    r = p && report_error_(b, block_state(b, l + 1)) && r;
    r = p && report_error_(b, consumeToken(b, RBRACE)) && r;
    r = p && if_expr_5(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // else_block?
  private static boolean if_expr_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_expr_5")) return false;
    else_block(b, l + 1);
    return true;
  }

  // FUNCTION LPAREN param_group? RPAREN LBRACE block_state RBRACE
  public static boolean func_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_expr")) return false;
    if (!nextTokenIsSmart(b, FUNCTION)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FUNC_EXPR, null);
    r = consumeTokensSmart(b, 1, FUNCTION, LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, func_expr_2(b, l + 1));
    r = p && report_error_(b, consumeTokensSmart(b, -1, RPAREN, LBRACE)) && r;
    r = p && report_error_(b, block_state(b, l + 1)) && r;
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // param_group?
  private static boolean func_expr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_expr_2")) return false;
    param_group(b, l + 1);
    return true;
  }

  // LBRACKET arguments RBRACKET
  public static boolean array_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_expr")) return false;
    if (!nextTokenIsSmart(b, LBRACKET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ARRAY_EXPR, null);
    r = consumeTokenSmart(b, LBRACKET);
    p = r; // pin = 1
    r = r && report_error_(b, arguments(b, l + 1));
    r = p && consumeToken(b, RBRACKET) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // LBRACE  map_arguments? RBRACE
  public static boolean map_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "map_expr")) return false;
    if (!nextTokenIsSmart(b, LBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MAP_EXPR, null);
    r = consumeTokenSmart(b, LBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, map_expr_1(b, l + 1));
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // map_arguments?
  private static boolean map_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "map_expr_1")) return false;
    map_arguments(b, l + 1);
    return true;
  }

  // IDENT
  public static boolean simple_ref_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_ref_expr")) return false;
    if (!nextTokenIsSmart(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokenSmart(b, IDENT);
    exit_section_(b, m, SIMPLE_REF_EXPR, r);
    return r;
  }

  // boolLiteral
  //           | numericLiteral
  //           | stringLiteral
  public static boolean literal_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literal_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL_EXPR, "<literal expr>");
    r = boolLiteral(b, l + 1);
    if (!r) r = numericLiteral(b, l + 1);
    if (!r) r = stringLiteral(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LPAREN expr RPAREN
  public static boolean paren_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paren_expr")) return false;
    if (!nextTokenIsSmart(b, LPAREN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PAREN_EXPR, null);
    r = consumeTokenSmart(b, LPAREN);
    p = r; // pin = 1
    r = r && report_error_(b, expr(b, l + 1, -1));
    r = p && consumeToken(b, RPAREN) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

}
