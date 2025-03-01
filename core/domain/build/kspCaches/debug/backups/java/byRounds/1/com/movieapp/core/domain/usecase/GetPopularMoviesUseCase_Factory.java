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
public final class GetPopularMoviesUseCase_Factory implements Factory<GetPopularMoviesUseCase> {
  private final Provider<MovieRepository> movieRepositoryProvider;

  public GetPopularMoviesUseCase_Factory(Provider<MovieRepository> movieRepositoryProvider) {
    this.movieRepositoryProvider = movieRepositoryProvider;
  }

  @Override
  public GetPopularMoviesUseCase get() {
    return newInstance(movieRepositoryProvider.get());
  }

  public static GetPopularMoviesUseCase_Factory create(
      Provider<MovieRepository> movieRepositoryProvider) {
    return new GetPopularMoviesUseCase_Factory(movieRepositoryProvider);
  }

  public static GetPopularMoviesUseCase newInstance(MovieRepository movieRepository) {
    return new GetPopularMoviesUseCase(movieRepository);
  }
}
