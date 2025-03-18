package com.tamerthedark.watchmultimodule.feature.details

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.movieapp.core.domain.model.ActorDomain
import java.util.Locale

@Composable
fun DetailsScreen(
    movieId: Int,
    onNavigateUp: () -> Unit,
    viewModel: DetailsViewModel = hiltViewModel()
) {
    // Load movie details when the screen is first displayed
    LaunchedEffect(movieId) {
        viewModel.getMovieDetails(movieId)
    }

    val state by viewModel.state.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1C1B1F))
    ) {
        when {
            state.isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = Color.White
                )
            }

            state.error != null -> {
                ErrorView(
                    message = state.error ?: "An unknown error occurred",
                    onRetry = { viewModel.getMovieDetails(movieId) },
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            state.movieDetail != null -> {
                val movieDetail = state.movieDetail

                // Determine which actors to display (use API data if available, otherwise empty list)
                val actorsToDisplay = movieDetail?.actors ?: emptyList()

                // Main content
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ) {
                    // Movie backdrop with gradient scrim and back button
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(400.dp)
                    ) {
                        // Backdrop image
                        AsyncImage(
                            model = movieDetail?.backdropUrl,
                            contentDescription = movieDetail?.title,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )

                        // Gradient overlay for readability
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(
                                    Brush.verticalGradient(
                                        colors = listOf(
                                            Color.Black.copy(alpha = 0.6f),
                                            Color.Transparent,
                                            Color(0xFF1C1B1F).copy(alpha = 0.95f)
                                        )
                                    )
                                )
                        )

                        // Top bar with back button
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                                .align(Alignment.TopStart),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            IconButton(
                                onClick = { onNavigateUp() },
                                modifier = Modifier
                                    .size(40.dp)
                                    .background(
                                        color = Color.Black.copy(alpha = 0.4f),
                                        shape = RoundedCornerShape(8.dp)
                                    )
                            ) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Back",
                                    tint = Color.White
                                )
                            }

                            // Favorite button
                            IconButton(
                                onClick = { /* Handle favorite */ },
                                modifier = Modifier
                                    .size(40.dp)
                                    .background(
                                        color = Color.Black.copy(alpha = 0.4f),
                                        shape = RoundedCornerShape(8.dp)
                                    )
                            ) {
                                Icon(
                                    imageVector = Icons.Default.FavoriteBorder,
                                    contentDescription = "Add to favorites",
                                    tint = Color.White
                                )
                            }
                        }
                    }

                    // Movie details content
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        // Title and year
                        Text(
                            text = movieDetail?.title ?: "",
                            style = MaterialTheme.typography.headlineSmall,
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        // Year and runtime in one row
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            Text(
                                text = movieDetail?.releaseDate?.take(4) ?: "",
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color.White.copy(alpha = 0.8f)
                            )

                            Text(
                                text = " • ${movieDetail?.formattedRuntime ?: ""}",
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color.White.copy(alpha = 0.8f)
                            )
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        // Rating with star icon
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            // Star icon
                            Text(
                                text = "★",
                                style = MaterialTheme.typography.bodyLarge,
                                color = Color(0xFFFFD700) // Gold color for star
                            )

                            Spacer(modifier = Modifier.width(4.dp))

                            Text(
                                text = String.format(Locale.US, "%.1f", movieDetail?.rating ?: 0.0),
                                style = MaterialTheme.typography.bodyLarge,
                                fontWeight = FontWeight.SemiBold,
                                color = Color.White
                            )

                            Text(
                                text = StringBuilder().append(" (")
                                    .append(
                                        String.format(
                                            Locale.US,
                                            "%,d",
                                            (movieDetail?.rating?.times(100))?.toInt() ?: 0
                                        )
                                    )
                                    .append(")").toString(),
                                style = MaterialTheme.typography.bodyMedium,
                                color = Color.White.copy(alpha = 0.6f)
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        // Genres as buttons
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            movieDetail?.genres?.take(4)?.forEach { genre ->
                                GenreButton(text = genre)
                                Spacer(modifier = Modifier.width(8.dp))
                            }
                        }

                        Spacer(modifier = Modifier.height(24.dp))

                        // Summary section
                        Text(
                            text = "Summary",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = movieDetail?.overview ?: "",
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.White.copy(alpha = 0.7f)
                        )

                        Spacer(modifier = Modifier.height(24.dp))

                        // Only show Cast section if we have actors to display
                        if (actorsToDisplay.isNotEmpty()) {
                            // Cast section
                            Text(
                                text = "Cast",
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            // Actors horizontal list
                            LazyRow(
                                horizontalArrangement = Arrangement.spacedBy(16.dp),
                                contentPadding = PaddingValues(end = 16.dp)
                            ) {
                                items(actorsToDisplay) { actor ->
                                    ActorItem(actor = actor)
                                }
                            }

                            Spacer(modifier = Modifier.height(24.dp))
                        }

                        // Spacer at the bottom for better scrolling experience
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun ActorItem(actor: ActorDomain) {
    Card(
        modifier = Modifier
            .width(100.dp)
            .height(170.dp), // Fixed height for all cards
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color.Gray.copy(alpha = 0.5f)),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF2D2D2D)
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(8.dp)
        ) {
            // Actor profile picture
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .background(Color.Gray.copy(alpha = 0.3f))
            ) {
                AsyncImage(
                    model = actor.profileUrl,
                    contentDescription = actor.name,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // Actor name - fixed height container
            Box(
                modifier = Modifier.height(36.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = actor.name,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }

            // Character name - fixed height container
            Box(
                modifier = Modifier.height(20.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = actor.character,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.White.copy(alpha = 0.7f),
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Composable
fun GenreButton(text: String) {
    Surface(
        shape = RoundedCornerShape(4.dp),
        color = Color(0xFF2D2D2D),
        contentColor = Color.White
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp),
            color = Color.White,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
fun ErrorView(
    message: String,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = message,
            style = MaterialTheme.typography.bodyLarge,
            color = Color.White,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onRetry,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.error
            )
        ) {
            Text("Try Again")
        }
    }
}