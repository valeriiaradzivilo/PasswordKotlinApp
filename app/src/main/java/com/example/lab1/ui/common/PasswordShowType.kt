package com.example.lab1.ui.common

enum class PasswordShowType {
    SYMBOLS, ASTERISKS;

    fun label(): String {
        return when (this) {
            SYMBOLS -> "Show password"
            ASTERISKS -> "Hide password"
        }

    }
}