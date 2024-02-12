package com.example.lab1.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ElevatedButton
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab1.ui.common.PasswordShowType
import com.example.lab1.ui.common.PasswordTextField
import com.example.lab1.ui.theme.Purple40
import com.example.lab1.ui.theme.PurpleGrey80

@Composable
fun PasswordInputScreen() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    var passwordShowType by remember { mutableStateOf(PasswordShowType.SYMBOLS) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = PurpleGrey80
    ) {
        Column(
            modifier = Modifier
                .padding(all = 8.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Fill in your password to start",
                style = TextStyle(
                    color = Purple40,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )
            )

            Spacer(modifier = Modifier.height(16.dp))

            PasswordTextField(
                text = text,
                onTextFieldValueChange = { text = it },
                useAsterisk = passwordShowType == PasswordShowType.ASTERISKS,
            )

            Spacer(modifier = Modifier.height(16.dp))

            for (type in PasswordShowType.entries) {
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

            Spacer(modifier = Modifier.height(16.dp))

            ElevatedButton(onClick = { /*TODO*/ }) {
                Text("OK")
            }

            Spacer(modifier = Modifier.height(50.dp))

            Text(
                modifier = Modifier.padding(8.dp),
                text = "Here you will see your text after pressing 'Ok' button: ",
                textAlign = TextAlign.Center,
            )

            OutlinedTextField(
                value = TextFieldValue(text = text.text),
                onValueChange = {},
                label = { Text("Result") },
            )
        }
    }
}

@Preview
@Composable
fun PasswordInputScreenPreview() {
    PasswordInputScreen()
}
