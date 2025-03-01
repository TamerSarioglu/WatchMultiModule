package com.movieapp.core.network.di;

import com.movieapp.core.network.api.MovieApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

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
public final class NetworkModule_ProvideMovieApiFactory implements Factory<MovieApi> {
  private final Provider<Retrofit> retrofitProvider;

  public NetworkModule_ProvideMovieApiFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public MovieApi get() {
    return provideMovieApi(retrofitProvider.get());
  }

  public static NetworkModule_ProvideMovieApiFactory create(Provider<Retrofit> retrofitProvider) {
    return new NetworkModule_ProvideMovieApiFactory(retrofitProvider);
  }

  public static MovieApi provideMovieApi(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideMovieApi(retrofit));
  }
}
