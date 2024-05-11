package br.com.estudo.chatbotapplication.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.estudo.chatbotapplication.components.ChatBubble
import br.com.estudo.chatbotapplication.components.ChatInput
import br.com.estudo.chatbotapplication.presentation.ViewEvent
import br.com.estudo.chatbotapplication.presentation.ViewState
import br.com.estudo.chatbotapplication.theme.ChatbotApplicationTheme

@Composable
fun MainScreenContent(
    modifier: Modifier,
    viewState: ViewState,
    onViewEvent: (ViewEvent) -> Unit
) {

    Surface(modifier = modifier) {
        Column {
            viewState.messages.forEach {
                Row {
                    if (it.isSender) {
                        Spacer(modifier = Modifier.weight(1f))
                    }

                    ChatBubble(
                        message = it.text
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            ChatInput(
                onConfirmClick = {
                    onViewEvent(ViewEvent.Message(it))
                },
            )
        }
    }
}

@Composable
@Preview(name = "Light theme", showBackground = true)
@Preview(name = "Dark theme", showBackground = true)
private fun MainScreenContentPreview() {
    ChatbotApplicationTheme {
        MainScreenContent(
            modifier = Modifier,
            viewState = viewStatePreviewMock(),
            onViewEvent = { }
        )
    }
}