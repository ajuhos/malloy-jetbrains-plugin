package com.wearebreak.malloyjetbrainsplugin

import com.intellij.lexer.FlexAdapter

class MalloyLexerAdapter : FlexAdapter(MalloyLexer(null))