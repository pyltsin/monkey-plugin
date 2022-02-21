package com.github.pyltsin.monkeyplugin.lexer

import com.intellij.lexer.FlexAdapter

class MonkeyFlexAdapter : FlexAdapter(MonkeyLexer(null))
