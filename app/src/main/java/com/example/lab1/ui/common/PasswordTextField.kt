package com.example.lab1.ui.common

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    text: TextFieldValue,
    onTextFieldValueChange: (TextFieldValue) -> Unit = {},
    useAsterisk: Boolean
) {
    OutlinedTextField(
        value = text,
        onValueChange = { onTextFieldValueChange(it) },
        label = { Text("Password") },
        modifier = modifier,
        visualTransformation = if (useAsterisk) PasswordVisualTransformation() else VisualTransformation.None,
    )
}
