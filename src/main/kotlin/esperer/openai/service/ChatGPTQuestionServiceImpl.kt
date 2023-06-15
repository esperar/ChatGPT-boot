package esperer.openai.service

import esperer.openai.dto.ChatGPTRequest
import esperer.openai.dto.ChatGPTResponse
import esperer.openai.dto.QuestionRequest
import org.apache.http.HttpEntity
import org.apache.http.client.HttpClient
import org.springframework.stereotype.Service

@Service
class ChatGPTQuestionServiceImpl(
    private val httpClient: HttpClient
) : ChatGPTQuestionService {

    override fun buildHttpEntity(request: ChatGPTRequest): HttpEntity {
        TODO("Not yet implemented")
    }

    override fun getResponse(chatGPTHttpEntity: HttpEntity): ChatGPTResponse {
        TODO("Not yet implemented")
    }

    override fun askQuestion(request: QuestionRequest): ChatGPTResponse {
        TODO("Not yet implemented")
    }

}