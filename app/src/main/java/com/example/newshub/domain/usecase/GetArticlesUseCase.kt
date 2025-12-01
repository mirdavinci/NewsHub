package com.example.newshub.domain.usecase

import com.example.newshub.domain.model.ArticleModel
import com.example.newshub.domain.repository.ArticleRepository

class GetArticlesUseCase (private val repository: ArticleRepository){

    suspend operator fun invoke(): List<ArticleModel> = repository.getArticles()
}