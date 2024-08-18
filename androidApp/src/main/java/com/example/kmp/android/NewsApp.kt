package com.example.kmp.android

import android.app.Application
import com.example.kmp.android.di.databaseModule
import com.example.kmp.android.di.viewModelsModule
import com.example.kmp.di.sharedModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NewsApp: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedModules + viewModelsModule + databaseModule

        startKoin {
            androidContext(this@NewsApp)
            modules(modules)

        }
    }


}