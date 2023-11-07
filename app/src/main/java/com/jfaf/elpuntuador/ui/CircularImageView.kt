package com.jfaf.elpuntuador.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun CircularImageView(imageRes: Int) {
    Box(
        modifier = Modifier
            .size(150.dp)
            .clip(CircleShape)
            .background(
                Brush.radialGradient(
                    colors = listOf(Color(0xFF1E90FF), Color(0xFF6A5ACD)),
                    center = Offset.Zero,
                    radius = 150f
                )
            )
    ) {
        Image(
            painter = rememberImagePainter(imageRes),
            contentDescription = null
        )
    }
}