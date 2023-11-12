package com.jfaf.elpuntuador.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jfaf.elpuntuador.data.Player
import com.jfaf.elpuntuador.ui.theme.ElPuntuadorTheme


@Composable
fun ElPuntuadorApp() {
    ElPuntuadorTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
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
