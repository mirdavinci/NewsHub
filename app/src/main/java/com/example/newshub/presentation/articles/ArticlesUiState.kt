package com.example.newshub.presentation.articles

import com.example.newshub.domain.model.ArticleModel

data class ArticlesUiState(
    val isLoading: Boolean = false,
    val articles: List<ArticleModel> = emptyList(),
    val error: String? = null
)