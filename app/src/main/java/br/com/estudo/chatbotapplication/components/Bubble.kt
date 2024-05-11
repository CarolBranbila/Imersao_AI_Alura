package br.com.estudo.chatbotapplication.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.estudo.chatbotapplication.theme.ChatbotApplicationTheme
import com.halilibo.richtext.commonmark.Markdown
import com.halilibo.richtext.ui.BasicRichText

@Composable
fun ChatBubble(
    modifier: Modifier = Modifier,
    message: String,
    isSender: Boolean = false,
) {
    Surface(
        modifier = modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .background(MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(8.dp)),
        contentColor = MaterialTheme.colorScheme.surface
    ) {
        BasicRichText(
            modifier = Modifier.padding(16.dp)
        ) {
            Markdown(content = message)
        }
    }
}

@Composable
@Preview(name = "Light theme", showBackground = true)
private fun ChatBubblePreview() {
    ChatbotApplicationTheme {
        Surface {
            ChatBubble(
                modifier = Modifier,
                message = "Test message"
            )
        }
    }
}
