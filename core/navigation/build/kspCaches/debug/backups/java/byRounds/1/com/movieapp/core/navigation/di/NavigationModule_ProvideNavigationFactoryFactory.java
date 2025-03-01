package com.movieapp.core.navigation.di;

import com.movieapp.core.navigation.MovieNavigationFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class NavigationModule_ProvideNavigationFactoryFactory implements Factory<MovieNavigationFactory> {
  @Override
  public MovieNavigationFactory get() {
    return provideNavigationFactory();
  }

  public static NavigationModule_ProvideNavigationFactoryFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static MovieNavigationFactory provideNavigationFactory() {
    return Preconditions.checkNotNullFromProvides(NavigationModule.INSTANCE.provideNavigationFactory());
  }

  private static final class InstanceHolder {
    private static final NavigationModule_ProvideNavigationFactoryFactory INSTANCE = new NavigationModule_ProvideNavigationFactoryFactory();
  }
}
