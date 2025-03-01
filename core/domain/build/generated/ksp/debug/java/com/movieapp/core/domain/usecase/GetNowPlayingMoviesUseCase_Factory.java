package com.movieapp.core.domain.usecase;

import com.movieapp.core.data.repository.MovieRepository;
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
public final class GetNowPlayingMoviesUseCase_Factory implements Factory<GetNowPlayingMoviesUseCase> {
  private final Provider<MovieRepository> movieRepositoryProvider;

  public GetNowPlayingMoviesUseCase_Factory(Provider<MovieRepository> movieRepositoryProvider) {
    this.movieRepositoryProvider = movieRepositoryProvider;
  }

  @Override
  public GetNowPlayingMoviesUseCase get() {
    return newInstance(movieRepositoryProvider.get());
  }

  public static GetNowPlayingMoviesUseCase_Factory create(
      Provider<MovieRepository> movieRepositoryProvider) {
    return new GetNowPlayingMoviesUseCase_Factory(movieRepositoryProvider);
  }

  public static GetNowPlayingMoviesUseCase newInstance(MovieRepository movieRepository) {
    return new GetNowPlayingMoviesUseCase(movieRepository);
  }
}
