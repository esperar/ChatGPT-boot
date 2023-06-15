package esperer.openai.gpt

import org.springframework.data.repository.CrudRepository

interface ChatGPTRepository : CrudRepository<ChatGPT, String>