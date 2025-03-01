package com.movieapp.core.domain.mapper;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class MovieMapper_Factory implements Factory<MovieMapper> {
  @Override
  public MovieMapper get() {
    return newInstance();
  }

  public static MovieMapper_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static MovieMapper newInstance() {
    return new MovieMapper();
  }

  private static final class InstanceHolder {
    private static final MovieMapper_Factory INSTANCE = new MovieMapper_Factory();
  }
}
