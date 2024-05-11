package br.com.estudo.chatbotapplication.presentation

sealed interface ViewEvent {

    data class Message(val text: String) : ViewEvent
}