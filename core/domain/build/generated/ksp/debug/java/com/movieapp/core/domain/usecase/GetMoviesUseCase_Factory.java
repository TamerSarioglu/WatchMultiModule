package com.movieapp.core.domain.usecase;

import com.movieapp.core.data.repository.MovieRepository;
import com.movieapp.core.domain.mapper.MovieMapper;
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
public final class GetMoviesUseCase_Factory implements Factory<GetMoviesUseCase> {
  private final Provider<MovieRepository> movieRepositoryProvider;

  private final Provider<MovieMapper> movieMapperProvider;

  public GetMoviesUseCase_Factory(Provider<MovieRepository> movieRepositoryProvider,
      Provider<MovieMapper> movieMapperProvider) {
    this.movieRepositoryProvider = movieRepositoryProvider;
    this.movieMapperProvider = movieMapperProvider;
  }

  @Override
  public GetMoviesUseCase get() {
    return newInstance(movieRepositoryProvider.get(), movieMapperProvider.get());
  }

  public static GetMoviesUseCase_Factory create(Provider<MovieRepository> movieRepositoryProvider,
      Provider<MovieMapper> movieMapperProvider) {
    return new GetMoviesUseCase_Factory(movieRepositoryProvider, movieMapperProvider);
  }

  public static GetMoviesUseCase newInstance(MovieRepository movieRepository,
      MovieMapper movieMapper) {
    return new GetMoviesUseCase(movieRepository, movieMapper);
  }
}
