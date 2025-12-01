package com.example.di

import com.example.newshub.data.repository.FakeArticleRepository
import com.example.newshub.domain.repository.ArticleRepository
import com.example.newshub.domain.usecase.GetArticleDetailUseCase
import com.example.newshub.domain.usecase.GetArticlesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Provides
    @Singleton
    fun provideArticleRepository(): ArticleRepository = FakeArticleRepository()

    @Provides
    @Singleton
    fun provideGetArticleUsecase(repository: ArticleRepository): GetArticlesUseCase =
        GetArticlesUseCase(repository)


    @Provides
    @Singleton
    fun provideGetArticleDetailsUsecase(repository: ArticleRepository): GetArticleDetailUseCase =
        GetArticleDetailUseCase(repository)

}