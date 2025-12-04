package com.example.myroom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
// Perhatikan import di bawah ini (Ganti m jadi M jika perlu)
import com.example.myroom.ui.theme.MyroomTheme
import com.example.myroom.view.uicontroller.SiswaApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            // Ganti m jadi M
            MyroomTheme {
                SiswaApp()
            }
        }
    }
}
