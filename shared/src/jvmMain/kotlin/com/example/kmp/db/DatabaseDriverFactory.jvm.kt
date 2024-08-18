package com.example.kmp.db

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import example.kmp.db.NewsDatabase

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver? {
        return JdbcSqliteDriver(
            url = "jdbc:sqlite:News.Database.db",
            schema = NewsDatabase.Schema

        )
    }

}