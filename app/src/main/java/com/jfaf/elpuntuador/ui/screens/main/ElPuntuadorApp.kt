package com.jfaf.elpuntuador.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.jfaf.elpuntuador.R
import com.jfaf.elpuntuador.ui.screens.shared.CommonTopBar


@Composable
fun ElPuntuadorApp(onUpClick: () -> Unit) {
    CommonTopBar(
        onUpClick = onUpClick,
        title = stringResource(id = R.string.main_title),
        showFB = false,
        onFBClick = {}
    ) { paddingValues ->
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier
                .background(
                    Brush.horizontalGradient(
                        colors = listOf(Color(0xFF1E90FF), Color(0xFF6A5ACD))
                    )
                )
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            ScoreScreen()
        }
    }
}
