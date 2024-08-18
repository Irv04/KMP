package com.example.kmp.di

import com.example.kmp.articles.di.articleModule

val sharedModules = listOf(
    articleModule,
    networkModule
)