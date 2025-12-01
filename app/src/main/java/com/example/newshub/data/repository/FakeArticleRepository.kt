package com.example.newshub.data.repository

import com.example.newshub.domain.model.ArticleModel
import com.example.newshub.domain.repository.ArticleRepository
import kotlinx.coroutines.delay
import java.util.UUID
import kotlin.uuid.Uuid

// this is our ArticleRepositoryImpl

class FakeArticleRepository : ArticleRepository {


    private val articles = List(10) { index ->
        ArticleModel(
            id = UUID.randomUUID().toString(), title = "Sample Article #$index",
            summary = "This is a short summary for article #$index.",
            content = "This is the full content of article #$index. " +
                    "Later you can replace this with real data from an API."
        )
    }

    override suspend fun getArticles(): List<ArticleModel> {

        delay(500)
        return articles

     }

    override suspend fun getArticleById(id: String): ArticleModel? {

        delay(200)
        return articles.find { it.id == id }

    }

}