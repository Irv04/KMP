package com.example.kmp.ui

import androidx.compose.animation.core.Transition
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.example.kmp.ui.screens.TabScreen
import org.koin.compose.getKoin
import org.koin.core.Koin

@Composable
fun App(koin: Koin = getKoin()) {
    MyApplicationTheme {
        Surface (
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ){
            Navigator(TabScreen(koin)) { navigator ->
                SlideTransition(navigator)
            }
        }

    }
}