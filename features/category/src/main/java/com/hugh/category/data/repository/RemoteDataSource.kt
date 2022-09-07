package com.hugh.category.data.repository

import com.hugh.category.data.network.CategoryApiService
import com.hugh.category.data.network.toEntity
import com.hugh.category.domain.state.ArticleState
import com.hugh.category.domain.state.CategoryType
import com.hugh.category.domain.state.CountryType
import javax.inject.Inject

internal class RemoteDataSource @Inject constructor(
    private val apiService: CategoryApiService
) {
    suspend fun getCategoryDetailList(
        categoryType: CategoryType,
        countryType: CountryType,
        page: Int,
        pageSize: Int
    ): ArticleState {
        return runCatching {
            ArticleState.Success(
                articlesEntity = apiService.getTopHeadlines(
                    country = countryType.toString(),
                    category = categoryType.toString(),
                    page = page,
                    pageSize = pageSize
                ).toEntity()
            )
        }.getOrElse {
            ArticleState.Failure(
                throwable = it
            )
        }
    }

    suspend fun getEverything(
        type: String,
        from: String?,
        to: String?,
        page: Int,
        pageSize: Int,
        sortType: String
    ): ArticleState {
        return runCatching {
            ArticleState.Success(
                articlesEntity = apiService.getEveryThing(
                    type, from, to, sortType, page, pageSize
                ).toEntity()
            )
        }.getOrElse {
            ArticleState.Failure(
                throwable = it
            )
        }
    }
}