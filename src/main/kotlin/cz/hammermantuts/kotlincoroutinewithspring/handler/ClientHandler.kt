package cz.hammermantuts.kotlincoroutinewithspring.handler


import cz.hammermantuts.kotlincoroutinewithspring.service.ClientService
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.json

@Component
class ClientHandlerImpl(
    private val clientService: ClientService,
) : ClientHandler {

    override suspend fun getClients(request: ServerRequest): ServerResponse {
        val clients = clientService.getAllClients()
        return ok()
            .json()
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValueAndAwait(clients)
    }
}

interface ClientHandler {
    suspend fun getClients(request: ServerRequest): ServerResponse
}