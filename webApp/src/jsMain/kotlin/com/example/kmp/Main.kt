package com.example.kmp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.CanvasBasedWindow
import com.example.kmp.di.initKoin
import com.example.kmp.ui.App

val koin = initKoin()

@OptIn(ExperimentalComposeUiApi::class)
fun main() {

    CanvasBasedWindow("News App") {
        Surface(modifier = Modifier.fillMaxSize()) {
            App(koin)
        }
    }
}