package com.example.kmp.di

import app.cash.sqldelight.db.SqlDriver
import com.example.kmp.db.DatabaseDriverFactory
import example.kmp.db.NewsDatabase
import org.koin.dsl.module

val databaseModule = module{

    single<SqlDriver> {
        DatabaseDriverFactory().createDriver()!!
    }

    single<NewsDatabase> {
        NewsDatabase(get())
    }

}