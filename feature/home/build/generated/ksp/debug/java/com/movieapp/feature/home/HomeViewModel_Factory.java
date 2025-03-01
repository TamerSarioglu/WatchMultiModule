package com.movieapp.feature.home;

import com.movieapp.core.domain.usecase.GetNowPlayingMoviesUseCase;
import com.movieapp.core.domain.usecase.GetPopularMoviesUseCase;
import com.movieapp.core.domain.usecase.GetTopRatedMoviesUseCase;
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
  private final Provider<GetPopularMoviesUseCase> getPopularMoviesUseCaseProvider;

  private final Provider<GetTopRatedMoviesUseCase> getTopRatedMoviesUseCaseProvider;

  private final Provider<GetNowPlayingMoviesUseCase> getNowPlayingMoviesUseCaseProvider;

  public HomeViewModel_Factory(Provider<GetPopularMoviesUseCase> getPopularMoviesUseCaseProvider,
      Provider<GetTopRatedMoviesUseCase> getTopRatedMoviesUseCaseProvider,
      Provider<GetNowPlayingMoviesUseCase> getNowPlayingMoviesUseCaseProvider) {
    this.getPopularMoviesUseCaseProvider = getPopularMoviesUseCaseProvider;
    this.getTopRatedMoviesUseCaseProvider = getTopRatedMoviesUseCaseProvider;
    this.getNowPlayingMoviesUseCaseProvider = getNowPlayingMoviesUseCaseProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(getPopularMoviesUseCaseProvider.get(), getTopRatedMoviesUseCaseProvider.get(), getNowPlayingMoviesUseCaseProvider.get());
  }

  public static HomeViewModel_Factory create(
      Provider<GetPopularMoviesUseCase> getPopularMoviesUseCaseProvider,
      Provider<GetTopRatedMoviesUseCase> getTopRatedMoviesUseCaseProvider,
      Provider<GetNowPlayingMoviesUseCase> getNowPlayingMoviesUseCaseProvider) {
    return new HomeViewModel_Factory(getPopularMoviesUseCaseProvider, getTopRatedMoviesUseCaseProvider, getNowPlayingMoviesUseCaseProvider);
  }

  public static HomeViewModel newInstance(GetPopularMoviesUseCase getPopularMoviesUseCase,
      GetTopRatedMoviesUseCase getTopRatedMoviesUseCase,
      GetNowPlayingMoviesUseCase getNowPlayingMoviesUseCase) {
    return new HomeViewModel(getPopularMoviesUseCase, getTopRatedMoviesUseCase, getNowPlayingMoviesUseCase);
  }
}
