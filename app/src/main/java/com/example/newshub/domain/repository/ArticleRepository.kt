package com.example.newshub.domain.repository

import com.example.newshub.domain.model.ArticleModel


interface ArticleRepository {

    suspend fun getArticles() : List<ArticleModel>
    suspend fun getArticleById(id: String): ArticleModel?


}