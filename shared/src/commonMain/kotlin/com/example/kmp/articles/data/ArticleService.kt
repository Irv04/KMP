package com.example.kmp.articles.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArticlesService(private val httpClient: HttpClient) {

    private val country = "us"
    private val category = "business"
    private val apiKey = "40c12872c38149a5a28260e537e2a447"

    suspend fun fetchArticles(): List<ArticleRaw> {
        val response: ArticlesResponse = httpClient.get("https://newsapi.org/v2/top-headlines?country=$country&category=$category&apiKey=$apiKey").body()
        return response.articles
    }

    suspend fun fetchEverything(): List<ArticleRaw>{
        val response: ArticlesResponse = httpClient.get("https://newsapi.org/v2/everything?q=bitcoin&apiKey=$apiKey").body()
        return response.articles
    }
}