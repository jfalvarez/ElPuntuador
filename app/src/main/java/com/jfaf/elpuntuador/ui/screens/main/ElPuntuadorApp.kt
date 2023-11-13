package com.jfaf.elpuntuador.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.jfaf.elpuntuador.R
import com.jfaf.elpuntuador.data.Player
import com.jfaf.elpuntuador.ui.screens.shared.ArrowBackIcon
import com.jfaf.elpuntuador.ui.theme.ElPuntuadorTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ElPuntuadorApp(onUpClick: () -> Unit) {
    ElPuntuadorTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(
                                text = stringResource(id = (R.string.modal_label)),
                                color = MaterialTheme.colorScheme.onPrimary
                            )
                        },
                        navigationIcon = { ArrowBackIcon(onUpClick = onUpClick) },
                        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        )
                    )
                }
            ) {
                Box(
                    contentAlignment = Alignment.TopCenter,
                    modifier = Modifier
                        .background(
                            Brush.horizontalGradient(
                                colors = listOf(Color(0xFF1E90FF), Color(0xFF6A5ACD))
                            )
                        )
                        .padding(it)
                        .fillMaxSize()
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
}
