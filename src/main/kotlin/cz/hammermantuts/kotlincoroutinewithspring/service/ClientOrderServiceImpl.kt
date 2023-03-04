package cz.hammermantuts.kotlincoroutinewithspring.service

import cz.hammermantuts.kotlincoroutinewithspring.domain.ClientDto
import cz.hammermantuts.kotlincoroutinewithspring.domain.ClientOrderDto
import cz.hammermantuts.kotlincoroutinewithspring.domain.CreateClientOrderDto
import cz.hammermantuts.kotlincoroutinewithspring.domain.OrderDto
import cz.hammermantuts.kotlincoroutinewithspring.entity.Order
import cz.hammermantuts.kotlincoroutinewithspring.extension.Mapper.toClientDto
import cz.hammermantuts.kotlincoroutinewithspring.extension.Mapper.toOrderDto
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.withContext
import org.slf4j.Logger
import org.springframework.stereotype.Service
import kotlin.coroutines.ContinuationInterceptor

@Service
class ClientOrderServiceImpl(
    private val clientService: ClientService,
    private val orderService: OrderService,
    private val emailService: EmailService,
    private val logger: Logger,
) : ClientOrderService {
    override suspend fun getAllClientWithOrders(): List<ClientOrderDto> = coroutineScope {
        val clients = async { clientService.getAllClients() }
        val orders = async { orderService.getOrders() }
        mapOrdersToClient(clients.await(), orders.await())
    }

    override suspend fun confirmAndSendOrder(request: CreateClientOrderDto) = coroutineScope {
        val client = async { clientService.getClientById(request.clientId) }
        val order = async { orderService.createOrder(request) }
        emailService.sendOrderConfirmationEmail(
            request.to,
            client.await().toClientDto(),
            order.await().toOrderDto()
        )

    }

    private suspend fun mapOrdersToClient(clients: List<ClientDto>, orders: List<Order>): List<ClientOrderDto> {
        val clientOrdersMap = orders.groupBy { it.clientId }
        return clients.map { client ->
            ClientOrderDto(
                client,
                clientOrdersMap[client.id]?.map { OrderDto(it.id!!, it.clientId!!, it.orderName, it.orderNumber) }
                    ?: emptyList())
        }
    }
}
