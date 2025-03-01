package com.movieapp.core.network.repository;

import com.movieapp.core.network.api.MovieApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class MovieRepositoryImpl_Factory implements Factory<MovieRepositoryImpl> {
  private final Provider<MovieApi> movieApiProvider;

  public MovieRepositoryImpl_Factory(Provider<MovieApi> movieApiProvider) {
    this.movieApiProvider = movieApiProvider;
  }

  @Override
  public MovieRepositoryImpl get() {
    return newInstance(movieApiProvider.get());
  }

  public static MovieRepositoryImpl_Factory create(Provider<MovieApi> movieApiProvider) {
    return new MovieRepositoryImpl_Factory(movieApiProvider);
  }

  public static MovieRepositoryImpl newInstance(MovieApi movieApi) {
    return new MovieRepositoryImpl(movieApi);
  }
}
