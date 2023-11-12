package com.jfaf.elpuntuador.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.jfaf.elpuntuador.data.Player

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayerView(player: Player) {
    Card(
        onClick = { },
        border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary),
        shape = CardDefaults.elevatedShape,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://cataas.com/cat?width=300&height=300")
//                .data("https://loremflickr.com/300/300/cat")
                    .crossfade(1000)
                    .build(),
                contentDescription = null,
//                modifier = Modifier.clip(RoundedCornerShape(10.dp)),
                contentScale = ContentScale.FillBounds
            )

            Text(
                text = player.name,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimary,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(25.dp))
        }
    }

}
