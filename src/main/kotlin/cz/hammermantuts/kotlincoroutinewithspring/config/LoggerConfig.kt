package cz.hammermantuts.kotlincoroutinewithspring.config

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class LoggerConfiguration {
    @Bean
    fun logger(): Logger {
        return LoggerFactory.getLogger("cz.hammermantuts.kotlincoroutinewithspring")
    }
}
