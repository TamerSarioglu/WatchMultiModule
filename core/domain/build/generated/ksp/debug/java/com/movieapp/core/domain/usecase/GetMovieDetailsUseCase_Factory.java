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
public final class GetMovieDetailsUseCase_Factory implements Factory<GetMovieDetailsUseCase> {
  private final Provider<MovieRepository> movieRepositoryProvider;

  private final Provider<MovieMapper> movieMapperProvider;

  public GetMovieDetailsUseCase_Factory(Provider<MovieRepository> movieRepositoryProvider,
      Provider<MovieMapper> movieMapperProvider) {
    this.movieRepositoryProvider = movieRepositoryProvider;
    this.movieMapperProvider = movieMapperProvider;
  }

  @Override
  public GetMovieDetailsUseCase get() {
    return newInstance(movieRepositoryProvider.get(), movieMapperProvider.get());
  }

  public static GetMovieDetailsUseCase_Factory create(
      Provider<MovieRepository> movieRepositoryProvider,
      Provider<MovieMapper> movieMapperProvider) {
    return new GetMovieDetailsUseCase_Factory(movieRepositoryProvider, movieMapperProvider);
  }

  public static GetMovieDetailsUseCase newInstance(MovieRepository movieRepository,
      MovieMapper movieMapper) {
    return new GetMovieDetailsUseCase(movieRepository, movieMapper);
  }
}
