package com.example.kmp.articles.di

import com.example.kmp.articles.data.ArticlesDataSource
import com.example.kmp.articles.data.ArticlesRepository
import com.example.kmp.articles.data.ArticlesService
import com.example.kmp.articles.domain.ArticlesUseCase
import com.example.kmp.articles.presentation.ArticlesViewModel
import com.example.kmp.articles.presentation.EverythingViewModel
import org.koin.dsl.module

val articleModule = module {
    single<ArticlesService> {
        ArticlesService(get())
    }

    single<ArticlesUseCase> {
        ArticlesUseCase(get())
    }

    single<ArticlesViewModel> {
        ArticlesViewModel(get())
    }

    single<EverythingViewModel> {
        EverythingViewModel(get())
    }

    single<ArticlesDataSource> {
        ArticlesDataSource(getOrNull())
    }

    single<ArticlesRepository> {
        ArticlesRepository(get(), get())
    }
}