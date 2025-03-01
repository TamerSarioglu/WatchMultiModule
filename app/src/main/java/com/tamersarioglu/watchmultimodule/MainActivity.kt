package com.tamersarioglu.watchmultimodule

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.movieapp.core.navigation.MovieNavigationFactory
import com.movieapp.feature.home.HomeScreen
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
                    
                    navigationFactory.CreateNavigation(
                        navController = navController,
                        homeScreen = {
                            HomeScreen(
                                onMovieClick = { movieId ->
                                    navController.navigate("movie/$movieId")
                                }
                            )
                        },
                        popularScreen = { /* Will be implemented later */ },
                        topRatedScreen = { /* Will be implemented later */ },
                        movieDetailScreen = { /* Will be implemented later */ }
                    )
                }
            }
        }
    }
}