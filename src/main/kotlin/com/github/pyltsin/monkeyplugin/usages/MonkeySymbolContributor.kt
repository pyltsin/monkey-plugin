package com.github.pyltsin.monkeyplugin.usages

import com.github.pyltsin.monkeyplugin.psi.MonkeyNamedElement
import com.github.pyltsin.monkeyplugin.stubs.MonkeyVarNameIndex
import com.intellij.navigation.ChooseByNameContributorEx
import com.intellij.navigation.NavigationItem
import com.intellij.openapi.progress.ProgressManager
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.stubs.StubIndex
import com.intellij.util.Processor
import com.intellij.util.indexing.FindSymbolParameters
import com.intellij.util.indexing.IdFilter

class MonkeySymbolContributor : ChooseByNameContributorEx {
    private val myIndexKeys = listOf(MonkeyVarNameIndex.KEY)
    override fun processNames(
        processor: Processor<in String>,
        scope: GlobalSearchScope,
        filter: IdFilter?
    ) {
        for (key in myIndexKeys) {
            ProgressManager.checkCanceled()
            StubIndex.getInstance().processAllKeys(
                key,
                processor,
                scope,
                filter
            )
        }
    }

    override fun processElementsWithName(
        name: String,
        processor: Processor<in NavigationItem>,
        parameters: FindSymbolParameters
    ) {
        for (key in myIndexKeys) {
            ProgressManager.checkCanceled()
            StubIndex.getInstance().processElements(
                key,
                name,
                parameters.project,
                parameters.searchScope,
                parameters.idFilter,
                MonkeyNamedElement::class.java,
                processor
            )
        }
    }
}
