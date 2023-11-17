package com.jfaf.elpuntuador.ui.screens.newgame

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jfaf.elpuntuador.R
import com.jfaf.elpuntuador.ui.screens.shared.CommonTopBar
import org.koin.androidx.compose.koinViewModel

@Composable
fun NewGameView(
    onUpClick: () -> Unit,
    onStartClicked: (Int) -> Unit,
    viewModel: NewGameViewModel = koinViewModel(),
) {
    var showNewPlayerDialog by remember { mutableStateOf(false) }
    CommonTopBar(
        title = stringResource(id = R.string.new_game_title),
        onUpClick = onUpClick,
        showFB = true,
        onFBClick = { showNewPlayerDialog = true }
    ) { paddingValues ->



        val newGameState by viewModel.state.collectAsState()

        LazyColumn(
            contentPadding = paddingValues, modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            item {
                Text(
                    text = "Elige uno de los jugadores existentes",
                    style = MaterialTheme.typography.headlineSmall
                )
            }
            items(newGameState.players.size) { position ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    var isChecked by remember{ mutableStateOf(newGameState.players[position].isSelected) }
                    Checkbox(
                        checked = isChecked,
                        onCheckedChange = {
                            newGameState.players[position].isSelected = it
                            isChecked = it
                        }
                    )
                    Text(
                        text = newGameState.players[position].name,
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
            item {
                Row(horizontalArrangement = Arrangement.Center, modifier = Modifier) {
                    Button(
                        onClick = {
                            viewModel.createGame()
                        },
                    ) {
                        Text(text = stringResource(id = R.string.new_game_button_text))
                    }
                }
            }

        }

        if(showNewPlayerDialog) {
            InputNewPlayerDialog(
                onDismissRequest = {
                    showNewPlayerDialog = false
                },
                onOkClicked = {
                    viewModel.insertPlayer(it)
                    showNewPlayerDialog = false
                }
            )
        }

        if(newGameState.startedGameId != -1) {
            onStartClicked(newGameState.startedGameId)
        }

    }
}