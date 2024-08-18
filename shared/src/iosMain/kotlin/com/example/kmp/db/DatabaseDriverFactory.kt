package com.example.kmp.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import example.kmp.db.NewsDatabase

actual class DatabaseDriverFactory() {
    actual fun createDriver(): SqlDriver? {
        return NativeSqliteDriver(
            schema = NewsDatabase.Schema,
            name = "News.Database.db"
        )
    }

}