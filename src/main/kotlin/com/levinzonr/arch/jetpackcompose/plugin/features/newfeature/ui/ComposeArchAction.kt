package com.levinzonr.arch.jetpackcompose.plugin.features.newfeature.ui

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.psi.PsiDirectory
import com.levinzonr.arch.jetpackcompose.plugin.dependencies.ProjectDependencies
import com.levinzonr.arch.jetpackcompose.plugin.features.newfeature.injection.AdvancedViewModelFactory
import com.levinzonr.arch.jetpackcompose.plugin.features.newfeature.injection.ComposeArchDialogViewModelFactory

class ComposeArchAction: AnAction() {

    override fun actionPerformed(e: AnActionEvent) {
        val deps = ProjectDependencies(e.project)
        val directory = e.getData(CommonDataKeys.PSI_ELEMENT) as PsiDirectory
        val viewModel = ComposeArchDialogViewModelFactory.create(directory, deps)
        val advancedViewModel = AdvancedViewModelFactory.create(deps)
        ComposeArchDialog(viewModel, advancedViewModel).show()
    }
}