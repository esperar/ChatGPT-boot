package esperer.openai.choice

import org.springframework.data.repository.CrudRepository

interface ChoiceRepository : CrudRepository<Choice, String> {
}