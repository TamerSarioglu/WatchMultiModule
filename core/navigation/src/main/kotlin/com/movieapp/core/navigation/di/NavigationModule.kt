package com.movieapp.core.navigation.di

import com.movieapp.core.navigation.MovieNavigationFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NavigationModule {
    
    @Provides
    @Singleton
    fun provideNavigationFactory(): MovieNavigationFactory {
        return MovieNavigationFactory()
    }
} 