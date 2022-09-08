package com.hugh.category.data.usecase

import com.hugh.category.domain.entity.ArticleEntity
import com.hugh.category.domain.repository.ArticleRepository
import com.hugh.category.domain.state.ArticleState
import com.hugh.category.domain.usecase.ArticleUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class ArticleUseCaseImpl @Inject constructor(
    private val articleRepository: ArticleRepository
) : ArticleUseCase {

    override suspend fun getEveryThing(
        type: String,
        from: String?,
        to: String?,
        sortType: String
    ): ArticleState {
        return articleRepository.getEverything(
            type = type,
            from = from,
            to = to,
            sortType = sortType
        )
    }

    override suspend fun insertArticle(article: ArticleEntity) {
        articleRepository.insertArticle(article)
    }

    override suspend fun deleteArticle(id: String) {
        articleRepository.deleteArticle(id)
    }

    override suspend fun getArticleFlow(): Flow<ArticleEntity> {
        return articleRepository.getArticleFlow()
    }
}