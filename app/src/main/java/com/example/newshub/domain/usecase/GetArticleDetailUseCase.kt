package com.example.newshub.domain.usecase

import com.example.newshub.domain.model.ArticleModel
import com.example.newshub.domain.repository.ArticleRepository

class GetArticleDetailUseCase(private val repository: ArticleRepository) {


    suspend operator fun invoke(id: String): ArticleModel? = repository.getArticleById(id)


}