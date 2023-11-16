package com.jfaf.elpuntuador.ui.screens.main

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.jfaf.elpuntuador.R
import com.jfaf.elpuntuador.model.data.entities.Player
import com.jfaf.elpuntuador.model.data.entities.PlayerOnGame

@Composable
fun PlayerView(playerReceived: PlayerOnGame, viewModel: PlayerViewViewModel) {
    var score by rememberSaveable { mutableIntStateOf(playerReceived.score) }
    var showDialog by remember { mutableStateOf(false) }
    ElevatedCard(
        shape = CardDefaults.elevatedShape,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary),
        elevation = CardDefaults.elevatedCardElevation(4.dp),
        modifier = Modifier.clickable { showDialog = true },
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://cataas.com/cat?width=300&height=300")
                    .error(drawableResId = R.drawable.img_error)
//                .data("https://loremflickr.com/300/300/cat")
                    .crossfade(1000)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )

            Text(
                text = playerReceived.name,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(10.dp))
            AnimatedContent(
                targetState = score,
                label = "",
                transitionSpec = {
                    slideInVertically { fullHeight -> fullHeight } togetherWith slideOutVertically { fullHeight -> -fullHeight }
                }
            ) {
                Text(
                    text = stringResource(R.string.main_score, it),
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onPrimary,
                    textAlign = TextAlign.Center
                )
            }

            Spacer(modifier = Modifier.height(25.dp))
        }
    }
    if (showDialog) {
        InputScoreDialog(
            onDismissRequest = { showDialog = false },
            onScoreConfirmed = {
                score = it
                viewModel.updateScore( it, playerReceived.playerId)
           },
            player = playerReceived
        )
    }

}
