package br.com.estudo.chatbotapplication.ui

import br.com.estudo.chatbotapplication.presentation.MessagesViewState
import br.com.estudo.chatbotapplication.presentation.ViewState

internal fun viewStatePreviewMock() = ViewState(
    messages = listOf(
        MessagesViewState(
            text = "Ola como vai voce",
            isSender = true
        ),
        MessagesViewState(
            text = "Muito bem e voce?",
            isSender = false
        ),
        MessagesViewState(
            text = "Otimo",
            isSender = true
        ),
        MessagesViewState(
            text = "Me faça algo legal",
            isSender = true
        ),
    )
)