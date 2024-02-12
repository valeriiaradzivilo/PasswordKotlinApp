package com.example.lab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.lab1.ui.theme.Lab1Theme

enum class PasswordShowType { SYMBOLS, ASTERISKS }

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab1Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var text by remember { mutableStateOf(TextFieldValue("")) }
                    var passwordShowType by remember { mutableStateOf(PasswordShowType.SYMBOLS) }

                    Column(
                        modifier = Modifier
                            .padding(all = 8.dp)
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        PasswordTextField(
                            text = text,
                            onTextFieldValueChange = { text = it },
                            useAsterisk = passwordShowType == PasswordShowType.ASTERISKS,
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        for (type in PasswordShowType.values()) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                            ) {
                                RadioButton(
                                    selected = passwordShowType == type,
                                    onClick = { passwordShowType = type }
                                )
                                Text(text = type.name)
                            }
                        }
                    }
                }
            }
        }
    }
}

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
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        )
    )
}
