package com.github.pyltsin.monkeyplugin.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.github.pyltsin.monkeyplugin.MonkeyTypes.*;

%%

%{
  public MonkeyLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class MonkeyLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R

INT=[0-9]+
STRING=\"[^\"]*\"
IDENT=[a-zA-Z_]+

NEW_LINE=(\r|\n|\r\n)
WHITE_SPACE=(\s|\t)+

%%
<YYINITIAL> {
  "fn"               { return FUNCTION; }
  "let"              { return LET; }
  "true"             { return TRUE; }
  "false"            { return FALSE; }
  "if"               { return IF; }
  "else"             { return ELSE; }
  "return"           { return RETURN; }
  "="                { return ASSIGN; }
  "+"                { return PLUS; }
  "-"                { return MINUS; }
  "!"                { return BANG; }
  "*"                { return ASTERISK; }
  "/"                { return SLASH; }
  "<"                { return LT; }
  ">"                { return GT; }
  "=="               { return EQ; }
  "!="               { return NOT_EQ; }
  ","                { return COMMA; }
  ";"                { return SEMICOLON; }
  ":"                { return COLON; }
  "("                { return LPAREN; }
  ")"                { return RPAREN; }
  "{"                { return LBRACE; }
  "}"                { return RBRACE; }
  "["                { return LBRACKET; }
  "]"                { return RBRACKET; }
  "BAD_CHARACTER"    { return BAD_CHARACTER; }

  {INT}              { return INT; }
  {STRING}           { return STRING; }
  {IDENT}            { return IDENT; }
  {NEW_LINE}         { return NEW_LINE; }
  {WHITE_SPACE}      { return WHITE_SPACE; }

}

[^] { return BAD_CHARACTER; }
