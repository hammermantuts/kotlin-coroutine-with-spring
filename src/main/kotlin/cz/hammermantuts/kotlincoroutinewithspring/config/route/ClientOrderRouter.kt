package cz.hammermantuts.kotlincoroutinewithspring.config.route

import cz.hammermantuts.kotlincoroutinewithspring.handler.ClientOrderHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.coRouter

@Configuration
open class ClientOrderRouter(
    private val clientOrderHandler: ClientOrderHandler
) {

    @Bean
    open fun clientOrderRouting(): RouterFunction<ServerResponse> = coRouter {
        "/api".nest {
            accept(MediaType.APPLICATION_JSON).nest {
                POST("/client-order", clientOrderHandler::createAndConfirmOrderForClient)
                GET("/client-order",clientOrderHandler::getClientsWithOrder)
            }
        }
    }
}