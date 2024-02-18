package com.example.lab1.ui.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

enum class PasswordShowType {
    SYMBOLS, ASTERISKS;

    fun label(): String {
        return when (this) {
            SYMBOLS -> "Show password"
            ASTERISKS -> "Hide password"
        }

    }


    companion object {
        @Composable
        fun Widget(passwordShowType: PasswordShowType, onClick: (PasswordShowType) -> Unit) {
            Column {
                for (type in entries) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        RadioButton(
                            selected = passwordShowType == type,
                            onClick = {
                                onClick(type)
                            }
                        )
                        Text(text = type.name)
                    }
                }

            }
        }
    }
}