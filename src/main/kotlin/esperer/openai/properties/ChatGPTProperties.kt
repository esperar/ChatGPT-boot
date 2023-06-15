package esperer.openai.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties("gpt")
data class ChatGPTProperties(
    val apiKey: String
)