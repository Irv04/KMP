package com.example.kmp.articles.data

import example.kmp.db.NewsDatabase

class ArticlesDataSource(
    private val database: NewsDatabase?
) {

    fun getAllArticles(): List<ArticleRaw>{
        return database?.newsDatabaseQueries?.selectAllArticles(::mapToArticleRaw)?.executeAsList() ?: emptyList()
    }

    fun insertArticles(articles: List<ArticleRaw>){
        database?.newsDatabaseQueries?.transaction {
            articles.forEach { article ->
                insertArticle(article)
            }
        }
    }

    private fun insertArticle(articleRaw: ArticleRaw){
        database?.newsDatabaseQueries?.insertArticle(
            articleRaw.title,
            articleRaw.desc,
            articleRaw.date,
            articleRaw.imageUrl
        )
    }

    fun clearArticles(){
        database?.newsDatabaseQueries?.removeAllArticles()
    }

    private fun mapToArticleRaw(
        title: String,
        desc: String?,
        date: String,
        imageUrl: String?
    ): ArticleRaw {
        return ArticleRaw(title, desc, date, imageUrl)
    }
}