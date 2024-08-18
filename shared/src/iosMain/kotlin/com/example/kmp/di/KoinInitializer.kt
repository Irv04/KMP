package com.example.kmp.di

import com.example.kmp.articles.presentation.ArticlesViewModel
import com.example.kmp.articles.presentation.EverythingViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun initKoin(){
    val modules = sharedModules + databaseModule

    startKoin {
        modules(modules)
    }
}

class ArticlesInjector: KoinComponent {

    val articlesViewModel: ArticlesViewModel by inject()

    val everythingViewModel: EverythingViewModel by inject()
}
