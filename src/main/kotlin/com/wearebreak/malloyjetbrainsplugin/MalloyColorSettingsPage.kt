package com.wearebreak.malloyjetbrainsplugin

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import com.intellij.icons.AllIcons
import javax.swing.Icon

class MalloyColorSettingsPage : ColorSettingsPage {
    private val DESCRIPTORS = arrayOf(
        AttributesDescriptor("Keyword", MalloySyntaxHighlighter.KEYWORD),
        AttributesDescriptor("Function", MalloySyntaxHighlighter.FUNCTION),
        AttributesDescriptor("Number", MalloySyntaxHighlighter.NUMBER),
        AttributesDescriptor("Date and Time", MalloySyntaxHighlighter.TIME),
        AttributesDescriptor("String", MalloySyntaxHighlighter.STRING),
        AttributesDescriptor("Comment", MalloySyntaxHighlighter.COMMENT)
    )

    override fun getIcon(): Icon = MalloyFileType.icon
    override fun getHighlighter(): SyntaxHighlighter = MalloySyntaxHighlighter()
    
    override fun getDemoText(): String = """
        // Malloy Sample
        source: users is table('users') {
          primary_key: id
        }

        query: active_users is users -> {
          group_by: id, name
          aggregate: user_count is count()
          where: last_login > @2023-01-01
          limit: 10
        }
    """.trimIndent()

    override fun getAdditionalHighlightingTagToDescriptorMap(): Map<String, TextAttributesKey>? = null
    override fun getAttributeDescriptors(): Array<AttributesDescriptor> = DESCRIPTORS
    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY
    override fun getDisplayName(): String = "Malloy"
}