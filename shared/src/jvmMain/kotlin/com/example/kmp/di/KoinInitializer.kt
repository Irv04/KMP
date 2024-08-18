package com.example.kmp.di

import org.koin.core.context.startKoin

fun initKoin() = startKoin {
    modules(
        sharedModules + databaseModule
    )
}.koin