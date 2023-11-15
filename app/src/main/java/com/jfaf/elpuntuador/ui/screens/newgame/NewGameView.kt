package com.jfaf.elpuntuador.ui.screens.newgame

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jfaf.elpuntuador.R
import com.jfaf.elpuntuador.data.Player
import com.jfaf.elpuntuador.ui.screens.shared.CommonTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewGameView(onUpClick: () -> Unit, onFBClicked: () -> Unit) {
    CommonTopBar(
        title = stringResource(id = R.string.new_game_title),
        onUpClick = onUpClick,
        showFB = true,
        onFBClick = onFBClicked
    ) { paddingValues ->
//        val list = mutableListOf<Player>()
        val list = remember { mutableStateListOf<Player>() }

        LazyColumn(contentPadding = paddingValues, modifier = Modifier.fillMaxSize().padding(16.dp)) {
            items(list.size) { position ->
                Text(text = stringResource(R.string.new_game_name_typed, list[position].name))
            }
            item {
                var name by remember { mutableStateOf("") }
                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    keyboardActions = KeyboardActions(onDone = {
                        list.add(Player(list.size, name, 0))
                        name = ""
                    }),
                    singleLine = true,
                    label = { Text(stringResource(R.string.new_game_name), style = MaterialTheme.typography.bodyLarge) },
                )
            }
        }
    }
}