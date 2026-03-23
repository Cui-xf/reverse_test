package com.cc.qbq

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            QbqTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PasswordCheckScreen(
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}

@Composable
fun QbqTheme(content: @Composable () -> Unit) {
    MaterialTheme(content = content)
}

@Composable
fun PasswordCheckScreen(modifier: Modifier = Modifier) {
    var password by remember { mutableStateOf("") }
    var resultText by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("密码") },
            singleLine = true,
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                resultText = if (NativeAuth.aaa(password)) {
                    "校验通过"
                } else {
                    "校验失败"
                }
            },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text("校验")
        }
        resultText?.let { msg ->
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = msg)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PasswordCheckPreview() {
    QbqTheme {
        PasswordCheckScreen()
    }
}
