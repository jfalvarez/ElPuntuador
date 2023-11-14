package com.jfaf.elpuntuador.ui.screens.shared

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jfaf.elpuntuador.ui.theme.ElPuntuadorTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonTopBar(
    onUpClick: () -> Unit,
    title: String,
    content: @Composable (paddingValues: PaddingValues) -> Unit
) {
    ElPuntuadorTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(
                                text = title,
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
                content(it)
            }

        }
    }
}