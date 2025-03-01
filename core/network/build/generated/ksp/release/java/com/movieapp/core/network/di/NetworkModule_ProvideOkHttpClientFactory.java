package com.movieapp.core.network.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

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
public final class NetworkModule_ProvideOkHttpClientFactory implements Factory<OkHttpClient> {
  private final Provider<Interceptor> authInterceptorProvider;

  private final Provider<HttpLoggingInterceptor> loggingInterceptorProvider;

  public NetworkModule_ProvideOkHttpClientFactory(Provider<Interceptor> authInterceptorProvider,
      Provider<HttpLoggingInterceptor> loggingInterceptorProvider) {
    this.authInterceptorProvider = authInterceptorProvider;
    this.loggingInterceptorProvider = loggingInterceptorProvider;
  }

  @Override
  public OkHttpClient get() {
    return provideOkHttpClient(authInterceptorProvider.get(), loggingInterceptorProvider.get());
  }

  public static NetworkModule_ProvideOkHttpClientFactory create(
      Provider<Interceptor> authInterceptorProvider,
      Provider<HttpLoggingInterceptor> loggingInterceptorProvider) {
    return new NetworkModule_ProvideOkHttpClientFactory(authInterceptorProvider, loggingInterceptorProvider);
  }

  public static OkHttpClient provideOkHttpClient(Interceptor authInterceptor,
      HttpLoggingInterceptor loggingInterceptor) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideOkHttpClient(authInterceptor, loggingInterceptor));
  }
}
