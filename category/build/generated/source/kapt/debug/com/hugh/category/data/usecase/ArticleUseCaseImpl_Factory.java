// Generated by Dagger (https://dagger.dev).
package com.hugh.category.data.usecase;

import com.hugh.category.domain.repository.ArticleRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.inject.Provider;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ArticleUseCaseImpl_Factory implements Factory<ArticleUseCaseImpl> {
  private final Provider<ArticleRepository> articleRepositoryProvider;

  public ArticleUseCaseImpl_Factory(Provider<ArticleRepository> articleRepositoryProvider) {
    this.articleRepositoryProvider = articleRepositoryProvider;
  }

  @Override
  public ArticleUseCaseImpl get() {
    return newInstance(articleRepositoryProvider.get());
  }

  public static ArticleUseCaseImpl_Factory create(
      Provider<ArticleRepository> articleRepositoryProvider) {
    return new ArticleUseCaseImpl_Factory(articleRepositoryProvider);
  }

  public static ArticleUseCaseImpl newInstance(ArticleRepository articleRepository) {
    return new ArticleUseCaseImpl(articleRepository);
  }
}
