package com.movieapp.feature.search.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

// App theme colors
private val DarkBackground = Color(0xFF1C1B1F)
private val TextColor = Color.White
private val TextSecondaryColor = Color.White.copy(alpha = 0.7f)
private val AccentColor = Color(0xFF6650a4) // Primary purple from your theme

@Composable
fun EmptySearchView(
    query: String,
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
            imageVector = Icons.Outlined.Search,
            contentDescription = "No results",
            modifier = Modifier.size(72.dp),
            tint = AccentColor.copy(alpha = 0.7f)
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text(
            text = "No results found for \"$query\"",
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
            color = TextColor
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Text(
            text = "Try searching with different keywords or check for spelling errors.",
            style = MaterialTheme.typography.bodyMedium,
            textAlign = TextAlign.Center,
            color = TextSecondaryColor
        )
    }
} 