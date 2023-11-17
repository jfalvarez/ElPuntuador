package com.jfaf.elpuntuador.ui.screens.main

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel

@Composable
fun ScoreScreen(viewModel: PlayerViewViewModel = koinViewModel()) {
    val players by viewModel.state.collectAsState()
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(20.dp),
        verticalAlignment = Alignment.Top,
    ) {
        items(players.playerOnGame.size) {
            PlayerView(players.playerOnGame[it],viewModel)
            Spacer(modifier = Modifier.width(12.dp))
        }
    }
}