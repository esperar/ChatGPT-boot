package esperer.openai.choice

import esperer.openai.gpt.ChatGPT
import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import javax.persistence.ManyToOne

@RedisHash("choice")
class Choice(
    @Id
    val text: String,

    val index: Int,

    val finishReason: String,

    @ManyToOne
    val chatGPT: ChatGPT
)