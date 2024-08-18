package com.example.kmp.articles.data

class ArticlesRepository(
    private val dataSource: ArticlesDataSource,
    private val articlesService: ArticlesService
) {

    suspend fun getArticles(forceFetch: Boolean): List<ArticleRaw>{
        /*val articlesDb = dataSource.getAllArticles()
        if(articlesDb.isEmpty() || forceFetch) {
            dataSource.clearArticles()
            return articlesService.fetchArticles()
        }*/

        return articlesService.fetchArticles()

        //return articlesDb
    }

    suspend fun getEverything(): List<ArticleRaw> {
        return articlesService.fetchEverything()
    }
}