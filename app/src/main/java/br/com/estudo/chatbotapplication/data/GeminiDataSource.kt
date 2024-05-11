package br.com.estudo.chatbotapplication.data

import com.google.ai.client.generativeai.type.Content
import com.google.ai.client.generativeai.type.TextPart

class GeminiDataSource constructor(
    private val factory: GeminiFactory = GeminiFactory()
) {

    suspend fun getAnswer(prompt: PromptModel): GeminiResponse {
        val model = factory.create()

        return try {

            if (prompt.firstCall) {
                val response = model.generateContent(
                    Content(
                        role = "user",
                        parts = listOf(TextPart("input:300g de arroz 200g de feijão"))
                    ),
                    Content(
                        role = "model", parts = listOf(
                            TextPart(
                                "## Informações nutricionais para 300g de arroz e 200g de feijão (500g):\\n\\n**Total:**\\n\\n* **Calorias:** Aproximadamente 1680 kcal\\n* **Carboidratos:** 344g\\n* **Proteínas:** 62g\\n* **Gorduras:** 8g\\n* **Fibras:** 64g\\n\\n**Informações relevantes para:**\\n\\n* **Diabéticos:** Essa refeição contém alto teor de carboidratos (344g), o que pode impactar significativamente os níveis de glicose no sangue. É fundamental o acompanhamento com nutricionista para ajustar a quantidade de acordo com as necessidades individuais e considerar a ingestão com outros alimentos para balancear o índice glicêmico da refeição.\\n* **Celíacos:** Arroz e feijão são naturalmente livres de glúten, tornando essa refeição segura para celíacos. É importante verificar os rótulos dos produtos para certificar-se de que não houve contaminação cruzada durante o processamento.\\n* **Intolerantes à lactose:** Arroz e feijão são naturalmente livres de lactose, tornando essa refeição segura para intolerantes à lactose. É importante ter atenção a outros ingredientes que podem ser adicionados durante o preparo, como manteiga ou creme de leite. \\n\\n**Observações:**\\n\\n* Os valores nutricionais podem variar ligeiramente dependendo do tipo de arroz e feijão utilizados. \\n* As informações fornecidas são apenas estimativas e não substituem a consulta a um nutricionista ou médico.\\n* Para uma dieta balanceada, combine o arroz e feijão com outros alimentos ricos em nutrientes como legumes, verduras e carnes magras. \\n\\nLembre-se que cada indivíduo possui necessidades nutricionais específicas. Consulte um profissional de saúde para obter orientação individualizada. \uD83D\uDE09"
                            )
                        )
                    ),
                    Content(
                        role = "user",
                        parts = listOf(TextPart(prompt.prompt))
                    )
                )
                GeminiResponse(
                    prompt = response.text ?: "Não consegui responder : O"
                )
            } else {
                val response = model.generateContent(prompt.prompt)

                GeminiResponse(
                    prompt = response.text ?: "Não consegui responder"
                )
            }
        } catch (ex: Exception) {
            ex.printStackTrace()

            GeminiResponse(
                prompt = "Não consegui responder mesmo isso ai : /"
            )
        }
    }
}