package com.example.kmp.db

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import example.kmp.db.NewsDatabase

actual class DatabaseDriverFactory(
    private val androidContext: Context
) {
    actual fun createDriver(): SqlDriver? {
        return AndroidSqliteDriver(
            schema = NewsDatabase.Schema,
            context = androidContext,
            name = "News.Database.db"
        )
    }

}