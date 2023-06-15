package esperer.openai.service

import esperer.openai.dto.ChatGPTRequest
import esperer.openai.dto.ChatGPTResponse
import esperer.openai.dto.QuestionRequest
import org.apache.http.HttpEntity


interface ChatGPTQuestionService {
    fun buildHttpEntity(request: ChatGPTRequest): HttpEntity
    fun getResponse(chatGPTHttpEntity: HttpEntity): ChatGPTResponse
    fun askQuestion(request: QuestionRequest): ChatGPTResponse
}