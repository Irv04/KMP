package com.example.kmp.android.di

import com.example.kmp.articles.presentation.ArticlesViewModel
import com.example.kmp.articles.presentation.EverythingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {

    viewModel {
        ArticlesViewModel(get())
    }

    viewModel {
        EverythingViewModel(get())
    }
}