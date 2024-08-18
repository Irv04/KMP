package com.example.kmp.android.di

import app.cash.sqldelight.db.SqlDriver
import com.example.kmp.db.DatabaseDriverFactory
import example.kmp.db.NewsDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    single<SqlDriver> {
        DatabaseDriverFactory(androidContext()).createDriver()!!
    }

    single<NewsDatabase>{
        NewsDatabase(get())
    }
}