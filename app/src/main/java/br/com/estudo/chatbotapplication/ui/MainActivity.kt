package br.com.estudo.chatbotapplication.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import br.com.estudo.chatbotapplication.presentation.MainViewModel
import br.com.estudo.chatbotapplication.theme.ChatbotApplicationTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            ChatbotApplicationTheme {
                val viewState by viewModel.viewState.collectAsState()

                MainScreen(
                    viewState = viewState,
                    onViewEvent = {
                        viewModel.onViewEvent(it)
                    }
                )
            }
        }
    }
}
