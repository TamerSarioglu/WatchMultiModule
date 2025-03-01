package com.movieapp.feature.home;

import com.movieapp.core.domain.usecase.GetMoviesUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<GetMoviesUseCase> moviesUseCaseProvider;

  public HomeViewModel_Factory(Provider<GetMoviesUseCase> moviesUseCaseProvider) {
    this.moviesUseCaseProvider = moviesUseCaseProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(moviesUseCaseProvider.get());
  }

  public static HomeViewModel_Factory create(Provider<GetMoviesUseCase> moviesUseCaseProvider) {
    return new HomeViewModel_Factory(moviesUseCaseProvider);
  }

  public static HomeViewModel newInstance(GetMoviesUseCase moviesUseCase) {
    return new HomeViewModel(moviesUseCase);
  }
}
