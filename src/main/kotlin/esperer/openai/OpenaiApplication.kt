package esperer.openai

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
class OpenaiApplication

fun main(args: Array<String>) {
	runApplication<OpenaiApplication>(*args)
}
