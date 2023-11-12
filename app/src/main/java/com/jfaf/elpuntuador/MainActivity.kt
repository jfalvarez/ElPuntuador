package com.jfaf.elpuntuador

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.jfaf.elpuntuador.ui.ElPuntuadorApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ElPuntuadorApp()
        }
    }
}
