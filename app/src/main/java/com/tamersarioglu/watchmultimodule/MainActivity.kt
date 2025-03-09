package com.tamersarioglu.watchmultimodule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.movieapp.core.navigation.MovieNavigation
import com.movieapp.core.navigation.MovieNavigationFactory
import com.movieapp.core.navigation.rememberMovieNavigationActions
import com.movieapp.feature.home.MainScreen
import com.tamerthedark.watchmultimodule.feature.details.DetailsScreen
import com.tamersarioglu.watchmultimodule.ui.theme.WatchMultiModuleTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navigationFactory: MovieNavigationFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WatchMultiModuleTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val navController = rememberNavController()
                    val navigationActions = rememberMovieNavigationActions(navController)
                    
                    navigationFactory.CreateNavigation(
                        navController = navController,
                        homeScreen = {
                            MainScreen(
                                onMovieClick = { movieId ->
                                    navController.navigate(MovieNavigation.MovieDetail.createRoute(movieId))
                                },
                                onNavigateToSearch = {
                                    navController.navigate(MovieNavigation.Search.route)
                                },
                                onNavigateToFavorites = {
                                    navController.navigate(MovieNavigation.Favorites.route)
                                }
                            )
                        },
                        popularScreen = { /* Will be implemented later */ },
                        topRatedScreen = { /* Will be implemented later */ },
                        movieDetailScreen = { movieId ->
                            DetailsScreen(
                                movieId = movieId,
                                navigationActions = navigationActions
                            )
                        },
                        searchScreen = {
                            com.movieapp.feature.search.navigation.SearchRoute(
                                navigationActions = navigationActions
                            )
                        },
                        favoritesScreen = {
                            // Import and use your FavoritesScreen here
                        }
                    )
                }
            }
        }
    }
}