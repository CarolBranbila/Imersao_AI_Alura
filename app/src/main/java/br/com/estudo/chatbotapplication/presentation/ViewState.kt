package br.com.estudo.chatbotapplication.presentation

data class ViewState(
    val messages: List<MessagesViewState>
)

data class MessagesViewState(
    val text: String,
    val isSender: Boolean
)