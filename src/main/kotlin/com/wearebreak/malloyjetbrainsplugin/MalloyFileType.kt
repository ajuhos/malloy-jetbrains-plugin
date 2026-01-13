package com.wearebreak.malloyjetbrainsplugin

import com.intellij.icons.AllIcons
import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

object MalloyFileType : LanguageFileType(MalloyLanguage) {
    override fun getName() = "Malloy"
    override fun getDescription() = "Malloy language file"
    override fun getDefaultExtension() = "malloy"
    override fun getIcon(): Icon = AllIcons.FileTypes.Text /* IconLoader.getIcon("/icons/malloyIcon.svg", MalloyFileType::class.java) */
}