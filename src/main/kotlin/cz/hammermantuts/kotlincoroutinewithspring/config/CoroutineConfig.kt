package cz.hammermantuts.kotlincoroutinewithspring.config

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import kotlin.coroutines.CoroutineContext

@Configuration
open class CoroutineConfig {

    @Bean
    open fun defaultCoroutineScope(): CoroutineScope = CoroutineScope(Dispatchers.Default)

    @Bean
    fun analyticsCoroutineScope(): CoroutineScope = CoroutineScope(Dispatchers.Default)

    @Bean
    fun defaultCoroutineContext() : CoroutineContext = Dispatchers.Default
}