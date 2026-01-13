package com.wearebreak.malloyjetbrainsplugin

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType

class MalloySyntaxHighlighter : SyntaxHighlighterBase() {
    companion object {
        val KEYWORD = TextAttributesKey.createTextAttributesKey("MALLOY_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD)
        val FUNCTION = TextAttributesKey.createTextAttributesKey("MALLOY_FUNCTION", DefaultLanguageHighlighterColors.PREDEFINED_SYMBOL)
        val NUMBER = TextAttributesKey.createTextAttributesKey("MALLOY_NUMBER", DefaultLanguageHighlighterColors.NUMBER)
        val TIME = TextAttributesKey.createTextAttributesKey("MALLOY_TIME", DefaultLanguageHighlighterColors.CONSTANT)
        val STRING = TextAttributesKey.createTextAttributesKey("MALLOY_STRING", DefaultLanguageHighlighterColors.STRING)
        val COMMENT = TextAttributesKey.createTextAttributesKey("MALLOY_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
    }

    override fun getHighlightingLexer(): Lexer {
        // We will replace this with a real Lexer in the next step
        return MalloyLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType): Array<TextAttributesKey> {
        return when (tokenType) {
            MalloyTokenTypes.KEYWORD -> arrayOf(KEYWORD)
            MalloyTokenTypes.FUNCTION -> arrayOf(FUNCTION)
            MalloyTokenTypes.NUMBER -> arrayOf(NUMBER)
            MalloyTokenTypes.TIME -> arrayOf(TIME)
            MalloyTokenTypes.STRING -> arrayOf(STRING)
            MalloyTokenTypes.COMMENT -> arrayOf(COMMENT)
            else -> emptyArray()
        }
    }
}