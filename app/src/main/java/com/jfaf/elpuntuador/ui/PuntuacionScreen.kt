package com.jfaf.elpuntuador.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jfaf.elpuntuador.data.Player

@Composable
fun ScoreScreen(players: List<Player>) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.horizontalGradient(
                    colors = listOf(Color(0xFF1E90FF), Color(0xFF6A5ACD))
                )
            )
            .padding(20.dp)
    ) {
        items(players.size) {
            PlayerView(players[it])
            Spacer(modifier = Modifier.width(12.dp))
        }
    }
}