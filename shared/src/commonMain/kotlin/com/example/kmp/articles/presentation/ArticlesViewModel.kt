package com.example.kmp.articles.presentation

import com.example.kmp.BaseViewModel
import com.example.kmp.articles.domain.ArticlesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticlesViewModel(
    private val useCase: ArticlesUseCase
): BaseViewModel() {

    private val _articleState: MutableStateFlow<ArticlesState> = MutableStateFlow(ArticlesState(loading = true))

    val articlesState: StateFlow<ArticlesState> get() = _articleState

    init {
        getArticles()
    }

    fun getArticles(forceFetch: Boolean = false){
        scope.launch {
            _articleState.emit(ArticlesState(loading = true, articles = _articleState.value.articles))
            val fetchedArticles = useCase.getArticles(forceFetch)
            _articleState.emit(ArticlesState(loading = false, articles = fetchedArticles))
        }
    }

}