package com.example.kmp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.kmp.articles.presentation.EverythingViewModel
import com.example.kmp.ui.screens.common.ErrorMessage
import org.koin.compose.koinInject
import org.koin.core.Koin

@Composable
fun EverythingScreen(
    koin: Koin,
    everythingViewModel: EverythingViewModel = koin.get(),
) {
    val articlesState = everythingViewModel.everythingState.collectAsState()

    Column {

        if (articlesState.value.error != null)
            ErrorMessage(articlesState.value.error!!)
        if (articlesState.value.articles.isNotEmpty())
            ArticlesListView(everythingViewModel)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ArticlesListView(viewModel: EverythingViewModel) {

    val state = rememberPullRefreshState(
        refreshing = viewModel.everythingState.value.loading,
        onRefresh = { viewModel.getEverything() }
    )

    Box(modifier = Modifier.pullRefresh(state = state)){
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(viewModel.everythingState.value.articles) { article ->
                ArticleItemView(article = article)
            }
        }
        PullRefreshIndicator(
            refreshing = viewModel.everythingState.value.loading,
            state = state,
            modifier = Modifier.align(Alignment.TopCenter)
        )
    }

}