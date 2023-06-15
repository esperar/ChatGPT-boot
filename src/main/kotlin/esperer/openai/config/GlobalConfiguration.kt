package esperer.openai.config

import org.apache.http.client.HttpClient
import org.apache.http.impl.client.HttpClients
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GlobalConfiguration {

    @Bean
    fun httpClient(): HttpClient =  HttpClients.createDefault()
}