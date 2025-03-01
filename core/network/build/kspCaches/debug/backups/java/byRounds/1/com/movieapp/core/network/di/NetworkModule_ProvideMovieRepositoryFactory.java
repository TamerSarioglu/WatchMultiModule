package com.movieapp.core.network.di;

import com.movieapp.core.network.api.MovieApi;
import com.movieapp.core.network.repository.MovieRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class NetworkModule_ProvideMovieRepositoryFactory implements Factory<MovieRepository> {
  private final Provider<MovieApi> movieApiProvider;

  public NetworkModule_ProvideMovieRepositoryFactory(Provider<MovieApi> movieApiProvider) {
    this.movieApiProvider = movieApiProvider;
  }

  @Override
  public MovieRepository get() {
    return provideMovieRepository(movieApiProvider.get());
  }

  public static NetworkModule_ProvideMovieRepositoryFactory create(
      Provider<MovieApi> movieApiProvider) {
    return new NetworkModule_ProvideMovieRepositoryFactory(movieApiProvider);
  }

  public static MovieRepository provideMovieRepository(MovieApi movieApi) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideMovieRepository(movieApi));
  }
}
