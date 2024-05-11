package br.com.estudo.chatbotapplication.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.estudo.chatbotapplication.data.GeminiDataSource
import br.com.estudo.chatbotapplication.data.PromptModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel constructor(
) : ViewModel() {

    private val geminiDataSource: GeminiDataSource = GeminiDataSource()

    private val mutableViewState = MutableStateFlow(ViewState(
        messages = listOf()
    ))

    val viewState: StateFlow<ViewState> = mutableViewState

    private var firstMessage = true

    init {
        val newListBot = buildList {
            add(
                MessagesViewState(
                    text = "Escreva quais alimentos deseja consultar com suas respectivas quantidades:",
                    isSender = false
                )
            )
        }

        mutableViewState.tryEmit(mutableViewState.value.copy(messages = newListBot))
    }

    fun onViewEvent(event: ViewEvent) {
        when(event) {
            is ViewEvent.Message -> onMessage(event)
        }
    }

    private fun onMessage(event: ViewEvent.Message) {
        viewModelScope.launch {
            val currentMessages = mutableViewState.value.messages

            val newList = buildList {
               addAll(currentMessages)
               add(
                   MessagesViewState(
                       text = event.text,
                       isSender = true
                   )
               )
            }

            mutableViewState.tryEmit(mutableViewState.value.copy(messages = newList))

            val answer = geminiDataSource.getAnswer(
                prompt = PromptModel(
                    prompt = event.text,
                    firstCall = firstMessage
                )
            )

            if (firstMessage) {
                firstMessage = false
            }

            val currentMessagesBot = mutableViewState.value.messages

            val newListBot = buildList {
                addAll(currentMessagesBot)
                add(
                    MessagesViewState(
                        text = answer.prompt,
                        isSender = false
                    )
                )
            }

            mutableViewState.tryEmit(mutableViewState.value.copy(messages = newListBot))
        }
    }
}