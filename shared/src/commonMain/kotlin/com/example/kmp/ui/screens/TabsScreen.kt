package com.example.kmp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.koin.core.Koin


class TabScreen(val koin: Koin) : Screen {

    @Composable
    override fun Content() {
        TabScreenContent(koin)
    }

}

@Composable
fun TabScreenContent(koin: Koin){
    var tabIndex by remember { mutableStateOf(0) }

    val tabs = listOf("Top Headlines", "Everything")

    Column(modifier = Modifier.fillMaxWidth()) {
        AppBar()
        TabRow(selectedTabIndex = tabIndex) {
            tabs.forEachIndexed { index, title ->
                Tab(text = { Text(title) },
                    selected = tabIndex == index,
                    onClick = { tabIndex = index }
                )
            }
        }
        when (tabIndex) {
            0 -> ArticlesScreen(koin)
            1 -> EverythingScreen(koin)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AppBar(
) {
    val navigator = LocalNavigator.currentOrThrow
    TopAppBar(
        title = { Text(text = "Articles") },
        actions = {
            IconButton(onClick = {
                navigator.push(AboutScreen())
            }) {
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = "About Device Button",
                )
            }
        }
    )
}