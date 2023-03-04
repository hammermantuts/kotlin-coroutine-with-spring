package cz.hammermantuts.kotlincoroutinewithspring.config.route

import cz.hammermantuts.kotlincoroutinewithspring.handler.ClientHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.coRouter

@Configuration
open class ClientRouter(
    private val clientHandler: ClientHandler
) {

    @Bean
    open fun clientRouting() = coRouter {
        "/api".nest {
            accept(MediaType.APPLICATION_JSON).nest {
                GET("/client", clientHandler::getClients)
            }
        }
    }
}