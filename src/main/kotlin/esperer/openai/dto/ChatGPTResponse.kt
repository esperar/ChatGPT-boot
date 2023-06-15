package esperer.openai.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.io.Serializable
import java.time.LocalDate
import java.time.LocalDateTime

data class ChatGPTResponse(
    val id: String,
    @JsonProperty("object")
    val obj: String,
    val created: LocalDate,
    val model: String,
    val choices: List<Choice>
) : Serializable

data class Choice(
    val text: String,
    val index: Int,
    @JsonProperty("finish_reason")
    val finishReason: String
) : Serializable