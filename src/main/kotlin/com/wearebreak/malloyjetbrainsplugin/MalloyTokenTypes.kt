package com.wearebreak.malloyjetbrainsplugin

import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet

interface MalloyTokenTypes {
    companion object {
        @JvmField val KEYWORD = IElementType("MALLOY_KEYWORD", MalloyLanguage)
        @JvmField val FUNCTION = IElementType("MALLOY_FUNCTION", MalloyLanguage)
        @JvmField val NUMBER = IElementType("MALLOY_NUMBER", MalloyLanguage)
        @JvmField val TIME = IElementType("MALLOY_TIME", MalloyLanguage)
        @JvmField val STRING = IElementType("MALLOY_STRING", MalloyLanguage)
        @JvmField val COMMENT = IElementType("MALLOY_COMMENT", MalloyLanguage)
        @JvmField val IDENTIFIER = IElementType("MALLOY_IDENTIFIER", MalloyLanguage)

        @JvmField val COMMENTS = TokenSet.create(COMMENT)
        @JvmField val STRINGS = TokenSet.create(STRING)
    }
}