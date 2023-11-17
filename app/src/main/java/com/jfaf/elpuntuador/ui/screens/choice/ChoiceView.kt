package com.jfaf.elpuntuador.ui.screens.choice

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.jfaf.elpuntuador.R
import com.jfaf.elpuntuador.ui.screens.shared.CommonTopBar


@Composable
fun ChoiceView(
    onUpClick: () -> Unit,
    onNewGameClick: () -> Unit,
    onLoadGameClick: () -> Unit,
) {
    CommonTopBar(
        title = stringResource(id = R.string.choice_title),
        onUpClick = onUpClick,
        showFB = false,
        onFBClick = {}
    ) { paddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            val paddingModifier = Modifier.padding(10.dp)

            Card(
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                modifier = Modifier.clickable(onClick = onNewGameClick)
            ) {
                Text(
                    stringResource(R.string.choice_new_game_option),
                    modifier = paddingModifier
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Card(
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                modifier = Modifier.clickable(onClick = onLoadGameClick)
            ) {
                Text(
                    stringResource(R.string.choice_resume_game_option),
                    modifier = paddingModifier
                )
            }
        }
    }
}