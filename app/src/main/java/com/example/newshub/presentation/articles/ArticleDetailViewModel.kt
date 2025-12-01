package com.example.newshub.presentation.articles

import com.example.newshub.domain.model.ArticleModel

data class ArticleDetailViewModel(
    val isLoading: Boolean = false,
    val article: ArticleModel? = null,
    val error: String? = null
)