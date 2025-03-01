package com.movieapp.feature.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.movieapp.feature.home.components.ErrorView
import com.movieapp.feature.home.components.MovieSection

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onMovieClick: (Int) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Scaffold { paddingValues ->
        when {
            state.isLoading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
            state.error != null -> {
                ErrorView(
                    message = state.error ?: "Unknown error occurred",
                    onRetry = viewModel::retryLoading,
                    modifier = Modifier.padding(paddingValues)
                )
            }
            else -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(paddingValues)
                ) {
                    Spacer(modifier = Modifier.height(16.dp))
                    
                    MovieSection(
                        title = "Now Playing",
                        movies = state.nowPlayingMovies,
                        onMovieClick = onMovieClick
                    )
                    
                    Spacer(modifier = Modifier.height(24.dp))
                    
                    MovieSection(
                        title = "Popular Movies",
                        movies = state.popularMovies,
                        onMovieClick = onMovieClick
                    )
                    
                    Spacer(modifier = Modifier.height(24.dp))
                    
                    MovieSection(
                        title = "Top Rated Movies",
                        movies = state.topRatedMovies,
                        onMovieClick = onMovieClick
                    )
                    
                    Spacer(modifier = Modifier.height(16.dp))
                }
            }
        }
    }
} 