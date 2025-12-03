package com.example.newshub.presentation.articles

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newshub.domain.model.ArticleModel
import com.example.newshub.domain.usecase.GetArticleDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

data class ArticleDetailUiState(
    val isLoading: Boolean = false,
    val article: ArticleModel? = null,
    val error: String? = null
)

@HiltViewModel
class ArticleDetailViewModel @Inject constructor(

    private val getArticleDetailUseCase: GetArticleDetailUseCase
) : ViewModel() {

    private val _uiState = mutableStateOf(ArticleDetailUiState())
    val uiState: State<ArticleDetailUiState> = _uiState

    fun loadArticle(id: String) {

        _uiState.value = _uiState.value.copy(isLoading = true, error = null)
        viewModelScope.launch {
            try {
                val result = getArticleDetailUseCase(id)
                if (result != null) {

                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        article = result
                    )
                } else {
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        error = "Article not found"
                    )
                }
            } catch (e: Exception) {
                _uiState.value = _uiState.value.copy(
                    isLoading = false,
                    error = e.message ?: "Unknown error"
                )
            }
        }

    }


}