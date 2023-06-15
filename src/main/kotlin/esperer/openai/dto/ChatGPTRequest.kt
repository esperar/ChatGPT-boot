package esperer.openai.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable

data class ChatGPTRequest(
    val model: String,
    val prompt: String,
    @JsonProperty("max_tokens")
    val maxTokens: Int,
    val temperature: Double,
    @JsonProperty("top_p")
    val topP: Double
) : Serializable

data class QuestionRequest(
    val message: String
) : Serializable