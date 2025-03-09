package com.movieapp.feature.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.movieapp.feature.search.components.EmptySearchView
import com.movieapp.feature.search.components.MovieSearchItem

// App theme colors
private val DarkBackground = Color(0xFF1C1B1F)
private val TextColor = Color.White
private val TextSecondaryColor = Color.White.copy(alpha = 0.7f)
private val AccentColor = Color(0xFF6650a4) // Primary purple from your theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    onMovieClick: (Int) -> Unit,
    onBackClick: () -> Unit,
    viewModel: SearchViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    // Use pinnedScrollBehavior instead of enterAlwaysScrollBehavior to prevent color changes
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current
    
    // Focus the search field when the screen is first displayed
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }

    Scaffold(
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        containerColor = DarkBackground,
        contentColor = TextColor,
        topBar = {
            TopAppBar(
                title = {
                    SearchBar(
                        query = state.query,
                        onQueryChange = { viewModel.onEvent(SearchEvent.OnQueryChange(it)) },
                        onSearch = { 
                            viewModel.onEvent(SearchEvent.OnSearch)
                            keyboardController?.hide()
                            focusManager.clearFocus()
                        },
                        onClearQuery = { viewModel.onEvent(SearchEvent.OnClearSearch) },
                        modifier = Modifier.focusRequester(focusRequester)
                    )
                },
                scrollBehavior = scrollBehavior,
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = DarkBackground,
                    titleContentColor = TextColor,
                    navigationIconContentColor = TextColor,
                    // Set scrolledContainerColor to match containerColor to prevent color changes when scrolling
                    scrolledContainerColor = DarkBackground
                )
            )
        }
    ) { paddingValues ->
        when {
            state.isLoading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator(color = TextColor)
                }
            }
            
            state.error != null -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = state.error ?: "An unknown error occurred",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
            
            state.isEmpty && state.isSearching -> {
                EmptySearchView(
                    query = state.query,
                    modifier = Modifier.padding(paddingValues)
                )
            }
            
            state.searchResults.isNotEmpty() -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(vertical = 8.dp)
                ) {
                    items(state.searchResults) { movie ->
                        MovieSearchItem(
                            movie = movie,
                            onMovieClick = { onMovieClick(it) }
                        )
                    }
                }
            }
            
            !state.isSearching -> {
                SearchInitialState(
                    modifier = Modifier.padding(paddingValues)
                )
            }
        }
    }
}

@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onSearch: () -> Unit,
    onClearQuery: () -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = query,
        onValueChange = onQueryChange,
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp),
        placeholder = { 
            Text(
                "Search for movies...",
                color = TextSecondaryColor
            ) 
        },
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = TextColor
            )
        },
        trailingIcon = {
            if (query.isNotEmpty()) {
                IconButton(onClick = onClearQuery) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Clear search",
                        tint = TextColor
                    )
                }
            }
        },
        colors = TextFieldDefaults.colors(
            focusedTextColor = TextColor,
            unfocusedTextColor = TextColor,
            cursorColor = AccentColor,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedPlaceholderColor = TextSecondaryColor,
            unfocusedPlaceholderColor = TextSecondaryColor
        ),
        keyboardActions = KeyboardActions(
            onDone = { onSearch() }
        )
    )
}

@Composable
fun SearchInitialState(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search",
            modifier = Modifier.size(72.dp),
            tint = AccentColor.copy(alpha = 0.7f)
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = "Search for movies",
            style = MaterialTheme.typography.headlineSmall,
            color = TextColor
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Text(
            text = "Enter a movie title to start searching",
            style = MaterialTheme.typography.bodyLarge,
            color = TextSecondaryColor
        )
    }
} 