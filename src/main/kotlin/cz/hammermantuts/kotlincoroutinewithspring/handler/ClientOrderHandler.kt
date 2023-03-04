package cz.hammermantuts.kotlincoroutinewithspring.handler


import cz.hammermantuts.kotlincoroutinewithspring.domain.CreateClientOrderDto
import cz.hammermantuts.kotlincoroutinewithspring.service.ClientOrderService
import cz.hammermantuts.kotlincoroutinewithspring.utils.TraceIdService.withTraceId
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.reactive.awaitFirst
import org.slf4j.Logger
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.buildAndAwait
import org.springframework.web.reactive.function.server.json
import java.util.*

@Component
class ClientOrderHandlerImpl(
    private val clientOrderService: ClientOrderService,
    private val defaultCoroutineScope: CoroutineScope,
    private val logger: Logger,
) : ClientOrderHandler {
    override suspend fun createAndConfirmOrderForClient(request: ServerRequest): ServerResponse {
        val body = request.bodyToMono(CreateClientOrderDto::class.java).awaitFirst()
        val traceId = request.headers().firstHeader("X-Trace-Id") ?: UUID.randomUUID().toString()
        withTraceId(traceId) {
            defaultCoroutineScope.async {
                clientOrderService.confirmAndSendOrder(body)
            }.await()
        }

        return ok()
            .json()
            .contentType(MediaType.APPLICATION_JSON)
            .buildAndAwait()
    }

    override suspend fun getClientsWithOrder(request: ServerRequest): ServerResponse {

        val traceId = request.headers().firstHeader("X-Trace-Id") ?: UUID.randomUUID().toString()
        val response = withTraceId(traceId) {
            defaultCoroutineScope.async {
                val clients = clientOrderService.getAllClientWithOrders()
                ok()
                    .json()
                    .contentType(MediaType.APPLICATION_JSON)
                    .bodyValueAndAwait(clients)

            }.await()
        }
        logger.info("Response")
        return response
    }
}

interface ClientOrderHandler {
    suspend fun createAndConfirmOrderForClient(request: ServerRequest): ServerResponse

    suspend fun getClientsWithOrder(request: ServerRequest): ServerResponse
}
