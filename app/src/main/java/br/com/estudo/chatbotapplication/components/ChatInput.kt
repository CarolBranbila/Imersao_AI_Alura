package br.com.estudo.chatbotapplication.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.estudo.chatbotapplication.theme.ChatbotApplicationTheme

@Composable
fun ChatInput(
    modifier: Modifier = Modifier,
    onConfirmClick: (String) -> Unit
) {
    Row {
        var message by remember { mutableStateOf("") }
        Row(modifier) {
            TextField(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                value = message,
                onValueChange = {
                    message = it
                }
            )
            Button(
                onClick = {
                    if (message.isNotEmpty()) {
                        onConfirmClick(message)
                        message = "" // Clear message after send
                    }
                },
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Icon(Icons.Filled.Send, contentDescription = "Send message")
            }
        }
    }
}

@Composable
@Preview(name = "Light theme", showBackground = true)
private fun ChatInputPreview() {
    ChatbotApplicationTheme {
        ChatInput(modifier = Modifier) {

        }
    }
}