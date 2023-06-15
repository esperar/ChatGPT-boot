package esperer.openai.service

import esperer.openai.dto.ChatGPTResponse
import esperer.openai.dto.QuestionRequest
import org.apache.http.HttpEntity


interface ChatGPTQuestionService {
    fun askQuestion(request: QuestionRequest): ChatGPTResponse
}