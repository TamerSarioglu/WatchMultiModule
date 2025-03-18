package com.tamersarioglu.watchmultimodule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.movieapp.core.navigation.MovieNavigation
import com.movieapp.core.navigation.extensions.navigateToFavorites
import com.movieapp.core.navigation.extensions.navigateToMovieDetail
import com.movieapp.core.navigation.extensions.navigateToSearch
import com.movieapp.feature.favorites.navigation.favoritesGraph
import com.movieapp.feature.home.navigation.homeGraph
import com.tamerthedark.watchmultimodule.feature.details.navigation.detailsGraph
import com.movieapp.feature.search.navigation.searchGraph
import com.tamersarioglu.watchmultimodule.ui.theme.WatchMultiModuleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WatchMultiModuleTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    
                    NavHost(
                        navController = navController,
                        startDestination = MovieNavigation.Home.route
                    ) {
                        // Use the extension functions from each feature module
                        homeGraph(
                            onMovieClick = { movieId -> 
                                navController.navigateToMovieDetail(movieId)
                            },
                            onNavigateToSearch = { 
                                navController.navigateToSearch() 
                            },
                            onNavigateToFavorites = { 
                                navController.navigateToFavorites() 
                            }
                        )
                        
                        detailsGraph(
                            onNavigateUp = { 
                                navController.navigateUp() 
                            }
                        )
                        
                        searchGraph(
                            onNavigateUp = { 
                                navController.navigateUp() 
                            },
                            onMovieClick = { movieId ->
                                navController.navigateToMovieDetail(movieId)
                            }
                        )
                        
                        favoritesGraph(
                            onNavigateUp = { 
                                navController.navigateUp() 
                            },
                            onMovieClick = { movieId ->
                                navController.navigateToMovieDetail(movieId)
                            }
                        )
                    }
                }
            }
        }
    }
}