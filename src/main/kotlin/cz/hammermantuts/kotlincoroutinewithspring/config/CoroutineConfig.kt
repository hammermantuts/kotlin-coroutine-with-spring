package cz.hammermantuts.kotlincoroutinewithspring.config

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class CoroutineConfig {

    @Bean
    open fun defaultCoroutineScope(): CoroutineScope = CoroutineScope(Dispatchers.IO)
}