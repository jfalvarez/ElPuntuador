package com.jfaf.elpuntuador.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import com.jfaf.elpuntuador.data.Player
import com.jfaf.elpuntuador.ui.theme.ElPuntuadorTheme


@Composable
fun ElPuntuadorApp() {
    ElPuntuadorTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            Box(
                contentAlignment = Alignment.TopCenter, modifier = Modifier.background(
                    Brush.horizontalGradient(
                        colors = listOf(Color(0xFF1E90FF), Color(0xFF6A5ACD))
                    )
                )
            ) {
                val players = listOf(
                    Player(1, "Rocío", 0),
                    Player(2, "Sara", 0),
                    Player(3, "José", 0),
                )
                ScoreScreen(players)
            }
        }
    }
}
