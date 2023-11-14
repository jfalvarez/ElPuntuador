package com.jfaf.elpuntuador.ui.screens.shared

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.jfaf.elpuntuador.R
import com.jfaf.elpuntuador.ui.theme.ElPuntuadorTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonTopBar(
    onUpClick: () -> Unit,
    title: String,
    showFB: Boolean = false,
    onFBClick: () -> Unit,
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
                },
                floatingActionButton = {
                    if (showFB) {
                        ExtendedFloatingActionButton(
                            onClick = { onFBClick() },
                            icon = {
                                Icon(
                                    imageVector = Icons.Default.Done,
                                    contentDescription = null
                                )
                            },
                            text = { Text(text = stringResource(R.string.new_game_fb)) }
                        )
                    }
                }
            ) {
                content(it)
            }

        }
    }
}