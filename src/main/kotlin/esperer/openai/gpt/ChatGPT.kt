package esperer.openai.gpt

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import java.time.LocalDate

@RedisHash("gpt")
class ChatGPT(
    @Id
    val id: String,

    val obj: String,

    val created: LocalDate
)