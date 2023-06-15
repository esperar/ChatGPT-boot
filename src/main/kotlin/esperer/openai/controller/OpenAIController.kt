package esperer.openai.controller

import esperer.openai.dto.ChatGPTResponse
import esperer.openai.dto.QuestionRequest
import esperer.openai.service.ChatGPTQuestionService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("chat-gpt")
class OpenAIController(
    private val chatGPTQuestionService: ChatGPTQuestionService
) {

    @PostMapping("/question")
    fun question(@RequestBody request: QuestionRequest): ChatGPTResponse{
        return chatGPTQuestionService.askQuestion(request)
    }

}