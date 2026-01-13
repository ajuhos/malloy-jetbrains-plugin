
package com.wearebreak.malloyjetbrainsplugin

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext

class MalloyCompletionContributor : CompletionContributor() {
    init {
        extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement().withLanguage(MalloyLanguage),
            object : CompletionProvider<CompletionParameters>() {
                override fun addCompletions(
                    parameters: CompletionParameters,
                    context: ProcessingContext,
                    resultSet: CompletionResultSet
                ) {
                    val keywords = listOf(
                        "source", "query", "run", "project", "group_by",
                        "aggregate", "nest", "where", "order_by", "limit",
                        "index", "is", "extend", "import", "from", "join_one", "join_many"
                    )

                    val functions = listOf(
                        "table", "count", "sum", "avg", "min", "max", "now"
                    )

                    keywords.forEach {
                        resultSet.addElement(LookupElementBuilder.create(it).withBoldness(true))
                    }

                    functions.forEach {
                        resultSet.addElement(LookupElementBuilder.create(it).withTailText("()", true))
                    }
                }
            }
        )
    }
}