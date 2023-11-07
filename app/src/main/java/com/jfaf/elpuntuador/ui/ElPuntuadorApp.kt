package com.jfaf.elpuntuador.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.jfaf.elpuntuador.R
import com.jfaf.elpuntuador.ui.theme.ElPuntuadorTheme


@Composable
fun ElPuntuadorApp() {
    ElPuntuadorTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            CircularImageView(imageRes = R.drawable.ic_launcher_foreground)
        }
    }
}