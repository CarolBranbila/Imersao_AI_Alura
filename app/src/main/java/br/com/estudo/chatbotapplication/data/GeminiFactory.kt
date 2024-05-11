package br.com.estudo.chatbotapplication.data

import br.com.estudo.chatbotapplication.BuildConfig
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.BlockThreshold
import com.google.ai.client.generativeai.type.GenerationConfig
import com.google.ai.client.generativeai.type.HarmCategory
import com.google.ai.client.generativeai.type.SafetySetting

class GeminiFactory {

    fun create(): GenerativeModel {
        return GenerativeModel(
            apiKey = BuildConfig.API_KEY,
            modelName = "gemini-1.0-pro",
            generationConfig = generateConfig(),
            safetySettings = safetySettings()
        )
    }

    private fun safetySettings() = listOf(
        SafetySetting(
            harmCategory = HarmCategory.HARASSMENT,
            threshold = BlockThreshold.MEDIUM_AND_ABOVE
        ),
        SafetySetting(
            harmCategory = HarmCategory.HATE_SPEECH,
            threshold = BlockThreshold.MEDIUM_AND_ABOVE
        ),
        SafetySetting(
            harmCategory = HarmCategory.SEXUALLY_EXPLICIT,
            threshold = BlockThreshold.MEDIUM_AND_ABOVE
        ),
        SafetySetting(
            harmCategory = HarmCategory.DANGEROUS_CONTENT,
            threshold = BlockThreshold.MEDIUM_AND_ABOVE
        )
    )

    private fun generateConfig() = GenerationConfig.builder()
        .apply {
            temperature = 0.5f
            candidateCount = 1
        }
        .build()
}