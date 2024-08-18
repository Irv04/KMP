package com.example.kmp.articles.domain

import com.example.kmp.articles.data.ArticleRaw
import com.example.kmp.articles.data.ArticlesRepository


class ArticlesUseCase(
    private val repository: ArticlesRepository
) {

    suspend fun getArticles(forceFetch: Boolean): List<Article> {
        val articles = repository.getArticles(forceFetch)
        return mapArticles(articles)
    }

    suspend fun getEverything(): List<Article> {
        val articles = repository.getEverything()
        return mapArticles(articles)
    }

    private fun mapArticles(articleRaw: List<ArticleRaw>): List<Article>{
        return articleRaw.map {
            Article(
                title = it.title,
                desc = it.desc ?: "Click to find out more",
                date = it.date,
                imageUrl = it.imageUrl ?: "https://www.shutterstock.com/shutterstock/photos/1928997539/display_1500/stock-vector-breaking-news-template-with-d-red-and-blue-badge-breaking-news-text-on-dark-blue-with-earth-and-1928997539.jpg"
            )
        }

    }


}