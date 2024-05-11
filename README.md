![alimentos](https://github.com/CarolBranbila/Imersao_AI_Alura/assets/133697726/f2b1d3f5-97b8-4049-88a7-053bc731c3a4)

# NutrIAliado 🥑

Se você é um entusiasta da saúde, preocupado com alergias alimentares ou simplesmente deseja manter uma dieta equilibrada, nosso aplicativo nutricional alimentado pela inovadora tecnologia Google AI Studio e Google 1.0 Pro é a ferramenta perfeita para você!

Basta digitar a quantidade e o alimento desejado, instantaneamente receberá uma análise nutricional abrangente, incluindo:
* Quantidade de calorias
* Informações nutricionais detalhadas (carboidratos, proteínas, gorduras)
* Dados cruciais para indivíduos com doença celíaca, diabetes e intolerância à lactose.

Benefícios:
* Monitore com precisão sua ingestão de calorias
* Tome decisões alimentares informadas com base em informações nutricionais claras
* Evite alimentos que desencadeiam reações alérgicas ou intolerâncias alimentares
* Mantenha uma dieta saudável e equilibrada
* Agilize sua jornada de bem-estar

---

# Requisitos

Para executar este projeto é preciso:

- Java SDK 8
- Android SDK
- [API key](https://makersuite.google.com/app/apikey) do google AI

## Configurando o projeto

Apos clonar o projeto renomeie o arquivo chamado `keys.example.properties` para
`keys.properties` e altere seu conteudo com a sua chave de API key do google AI, devera ficar no
formato

```
API_KEY=abcdfe12312e
```

Onde `abcdfe12312e` é sua chave de API do google

Apos isso basta executar o projeto em algum celular ou emulador android

# Arquitetura

O projeto segue a arquitetura MVI usando Jetpack Compose

Nossa divisão segue a seguinte ideia:

## Presentation

Aqui estara nossas ViewModels e suas intençoes e estados

Teremos sempre uma sealed interface para representar quais eventos podem ser efetuados, 
no exemplo atual é a classe `ViewEvent` e tambem uma classe que represnta o nosso estado, 
a `ViewState`

## Domain

Aqui teremos as nossas regras, como este projeto é super simples não temos uma quebra entra a camada 
de dados e dominio

## Components

Aqui temos os nossos componentes de UI para o compose

---

# Sugestões

Para qualquer sugestoes ou divda abra uma issue por favor : )



