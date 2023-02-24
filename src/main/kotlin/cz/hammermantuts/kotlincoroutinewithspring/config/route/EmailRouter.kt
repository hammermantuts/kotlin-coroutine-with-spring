package cz.hammermantuts.kotlincoroutinewithspring.config.route

import cz.hammermantuts.kotlincoroutinewithspring.handler.EmailHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.coRouter

@Configuration
open class EmailRouter(
    private val emailHandler: EmailHandler,
) {

    @Bean
    open fun emailRouting(): RouterFunction<ServerResponse> = coRouter {
        "/api".nest {
            accept(MediaType.APPLICATION_JSON).nest {
                POST("/email", emailHandler::handle)
            }
        }
    }
}