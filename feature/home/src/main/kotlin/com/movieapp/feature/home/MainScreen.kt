package com.movieapp.feature.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.movieapp.feature.search.SearchScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    onMovieClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    onNavigateToSearch: () -> Unit,
    onNavigateToFavorites: () -> Unit
) {
    var selectedTab by remember { mutableStateOf(0) }
    
    // State to track current content
    val currentScreen = remember { mutableStateOf(0) }

    Scaffold(
        modifier = modifier,
        containerColor = Color(0xFF1C1B1F),
        bottomBar = {
            NavigationBar(
                containerColor = Color(0xFF1C1B1F),
                contentColor = Color.White
            ) {
                NavigationBarItem(
                    selected = selectedTab == 0,
                    onClick = { 
                        selectedTab = 0 
                        currentScreen.value = 0
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Home"
                        )
                    },
                    label = { Text("Home") },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color.White,
                        unselectedIconColor = Color.White.copy(alpha = 0.6f),
                        selectedTextColor = Color.White,
                        unselectedTextColor = Color.White.copy(alpha = 0.6f),
                        indicatorColor = Color.White.copy(alpha = 0.1f)
                    )
                )
                NavigationBarItem(
                    selected = selectedTab == 1,
                    onClick = { 
                        selectedTab = 1
                        currentScreen.value = 1
                        // Don't navigate away, just change the content
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search"
                        )
                    },
                    label = { Text("Search") },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color.White,
                        unselectedIconColor = Color.White.copy(alpha = 0.6f),
                        selectedTextColor = Color.White,
                        unselectedTextColor = Color.White.copy(alpha = 0.6f),
                        indicatorColor = Color.White.copy(alpha = 0.1f)
                    )
                )
                NavigationBarItem(
                    selected = selectedTab == 2,
                    onClick = { 
                        selectedTab = 2
                        currentScreen.value = 2
                        // Don't navigate away, just change the content
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = "Favorites"
                        )
                    },
                    label = { Text("Favorites") },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color.White,
                        unselectedIconColor = Color.White.copy(alpha = 0.6f),
                        selectedTextColor = Color.White,
                        unselectedTextColor = Color.White.copy(alpha = 0.6f),
                        indicatorColor = Color.White.copy(alpha = 0.1f)
                    )
                )
            }
        }
    ) { paddingValues ->
        // Show the appropriate screen based on the selected tab
        when (currentScreen.value) {
            0 -> HomeScreen(
                onMovieClick = onMovieClick,
                modifier = Modifier.padding(paddingValues)
            )
            1 -> SearchScreen(
                onMovieClick = onMovieClick,
                onBackClick = { 
                    // No-op: Removing back functionality as requested
                },
                modifier = Modifier.padding(paddingValues)
            )
            2 -> {
                // Call the favorites screen or a placeholder
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Favorites Screen", color = Color.White)
                }
                // Alternatively, call your actual favorites screen:
                // FavoritesScreen(
                //     onMovieClick = onMovieClick,
                //     modifier = Modifier.padding(paddingValues)
                // )
            }
        }
    }
} 