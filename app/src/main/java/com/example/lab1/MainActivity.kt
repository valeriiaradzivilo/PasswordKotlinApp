package com.example.lab1.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.lab1.ui.screens.PasswordInputScreen
import com.example.lab1.ui.theme.Lab1Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab1Theme {
                PasswordInputScreen()
            }
        }
    }
}
