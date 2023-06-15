package esperer.openai.service

import com.fasterxml.jackson.databind.ObjectMapper
import esperer.openai.dto.ChatGPTRequest
import esperer.openai.dto.ChatGPTResponse
import esperer.openai.dto.QuestionRequest
import esperer.openai.properties.ChatGPTProperties
import org.apache.http.HttpEntity
import org.apache.http.HttpHeaders
import org.apache.http.client.HttpClient
import org.apache.http.client.methods.HttpPost
import org.apache.http.entity.ContentType
import org.apache.http.entity.StringEntity
import org.apache.http.util.EntityUtils
import org.springframework.stereotype.Service

@Service
class ChatGPTQuestionServiceImpl(
    private val httpClient: HttpClient,
    private val chatGPTProperties: ChatGPTProperties,
    private val objectMapper: ObjectMapper
) : ChatGPTQuestionService {

    companion object {
        const val bearer = "Bearer "
        const val model = "text-davinci-003"
        const val maxTokens = 300
        const val temperature = 0.0
        const val topP = 1.0
        const val mediaType = "application/json; charset=UTF-8"
        const val url = "https://api.openai.com/v1/completions"
    }

    override fun askQuestion(request: QuestionRequest): ChatGPTResponse {
        val requestEntity = buildHttpEntity(
            ChatGPTRequest(
                model = model,
                prompt = request.message,
                maxTokens = maxTokens,
                temperature = temperature,
                topP = topP
            )
        )

        return getResponse(requestEntity)
    }

    private fun getResponse(chatGPTHttpEntity: HttpEntity): ChatGPTResponse {
        val httpPost = HttpPost(url)
        httpPost.entity = chatGPTHttpEntity

        val response = httpClient.execute(httpPost)
        val requestBody = EntityUtils.toString(response.entity)

        return objectMapper.readValue(requestBody, ChatGPTResponse::class.java)
    }

    private fun buildHttpEntity(request: ChatGPTRequest): HttpEntity {
        val headers = listOf(
            HttpHeaders.CONTENT_TYPE to mediaType,
            HttpHeaders.AUTHORIZATION to bearer + chatGPTProperties.apiKey
        )

        val requestBody = objectMapper.writeValueAsString(request)

        val httpPost = HttpPost(url)
            .apply { headers.forEach { (name, value) -> setHeader(name, value)  } }
        httpPost.entity = StringEntity(requestBody, ContentType.APPLICATION_JSON)

        return httpPost.entity
    }

}