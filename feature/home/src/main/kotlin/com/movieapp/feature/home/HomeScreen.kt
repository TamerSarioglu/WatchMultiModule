package com.movieapp.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.movieapp.feature.home.components.ErrorView
import com.movieapp.feature.home.components.MovieSection

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onMovieClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    when {
        state.isLoading -> {
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        state.error != null -> {
            ErrorView(
                message = state.error ?: "Unknown error occurred",
                onRetry = viewModel::retryLoading,
                modifier = modifier
            )
        }
        else -> {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                // Featured Movie Section - Random Popular Movie
                state.popularMovies.randomOrNull()?.let { featuredMovie ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(400.dp)
                    ) {
                        AsyncImage(
                            model = "https://image.tmdb.org/t/p/original${featuredMovie.backdropPath}",
                            contentDescription = featuredMovie.title,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                        
                        // Gradient scrim to make text more readable
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    brush = Brush.verticalGradient(
                                        colors = listOf(
                                            Color.Transparent,
                                            Color(0xFF1C1B1F).copy(alpha = 0.95f)
                                        ),
                                        startY = 0f,
                                        endY = Float.POSITIVE_INFINITY
                                    )
                                )
                        )
                        
                        Column(
                            modifier = Modifier
                                .align(Alignment.BottomStart)
                                .padding(16.dp)
                        ) {
                            Text(
                                text = "Trending this week",
                                style = MaterialTheme.typography.titleMedium,
                                color = Color.White.copy(alpha = 0.8f)
                            )
                            
                            Text(
                                text = featuredMovie.title,
                                style = MaterialTheme.typography.headlineMedium,
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                            
                            Row(
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    text = featuredMovie.releaseDate.take(4),
                                    color = Color.White.copy(alpha = 0.7f)
                                )
                                Text(
                                    text = "★ ${String.format("%.1f", featuredMovie.rating)}",
                                    color = Color.White.copy(alpha = 0.7f)
                                )
                            }

                            Text(
                                text = featuredMovie.overview,
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color.White.copy(alpha = 0.7f),
                                maxLines = 3,
                                overflow = TextOverflow.Ellipsis,
                                modifier = Modifier.padding(vertical = 8.dp)
                            )
                            
                            FilledTonalButton(
                                onClick = { onMovieClick(featuredMovie.id) },
                                modifier = Modifier.padding(top = 8.dp),
                                colors = ButtonDefaults.filledTonalButtonColors(
                                    containerColor = Color.White.copy(alpha = 0.1f),
                                    contentColor = Color.White
                                )
                            ) {
                                Text("Watch trailer")
                            }
                        }
                    }
                }
                
                Spacer(modifier = Modifier.height(16.dp))
                
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
                
                Spacer(modifier = Modifier.height(24.dp))
                
                MovieSection(
                    title = "Now Playing",
                    movies = state.nowPlayingMovies,
                    onMovieClick = onMovieClick
                )
                
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
} 