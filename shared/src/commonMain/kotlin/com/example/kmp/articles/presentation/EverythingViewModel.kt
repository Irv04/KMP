package com.example.kmp.articles.presentation

import com.example.kmp.BaseViewModel
import com.example.kmp.articles.domain.Article
import com.example.kmp.articles.domain.ArticlesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

data class EverythingState(
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null,
)

class EverythingViewModel(
    private val useCase: ArticlesUseCase
): BaseViewModel() {

    private val _everythingState: MutableStateFlow<EverythingState> = MutableStateFlow(EverythingState(loading = true))

    val everythingState: StateFlow<EverythingState> get() = _everythingState

    init {
        getEverything()
    }

    fun getEverything(){
        scope.launch {
            _everythingState.emit(EverythingState(loading = true, articles = _everythingState.value.articles))
            val fetchedArticles = useCase.getEverything()
            _everythingState.emit(EverythingState(articles = fetchedArticles))
        }
    }

}