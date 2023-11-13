package com.jfaf.elpuntuador.ui.screens.shared

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.jfaf.elpuntuador.R

@Composable
fun ArrowBackIcon(onUpClick: () -> Unit) {
    IconButton(onClick = onUpClick) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = stringResource(id = (R.string.modal_button_cancel)),
            tint = MaterialTheme.colorScheme.onPrimary
        )
    }
}