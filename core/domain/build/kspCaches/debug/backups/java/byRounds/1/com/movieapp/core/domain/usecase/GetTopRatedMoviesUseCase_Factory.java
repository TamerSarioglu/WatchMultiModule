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
public final class GetTopRatedMoviesUseCase_Factory implements Factory<GetTopRatedMoviesUseCase> {
  private final Provider<MovieRepository> movieRepositoryProvider;

  public GetTopRatedMoviesUseCase_Factory(Provider<MovieRepository> movieRepositoryProvider) {
    this.movieRepositoryProvider = movieRepositoryProvider;
  }

  @Override
  public GetTopRatedMoviesUseCase get() {
    return newInstance(movieRepositoryProvider.get());
  }

  public static GetTopRatedMoviesUseCase_Factory create(
      Provider<MovieRepository> movieRepositoryProvider) {
    return new GetTopRatedMoviesUseCase_Factory(movieRepositoryProvider);
  }

  public static GetTopRatedMoviesUseCase newInstance(MovieRepository movieRepository) {
    return new GetTopRatedMoviesUseCase(movieRepository);
  }
}
