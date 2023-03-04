package cz.hammermantuts.kotlincoroutinewithspring.service

import cz.hammermantuts.kotlincoroutinewithspring.domain.AddressDto
import cz.hammermantuts.kotlincoroutinewithspring.domain.ClientDto
import cz.hammermantuts.kotlincoroutinewithspring.domain.ClientOrderDto
import cz.hammermantuts.kotlincoroutinewithspring.entity.Order
import cz.hammermantuts.kotlincoroutinewithspring.extension.Mapper.toOrderDto
import io.kotest.matchers.collections.shouldContainExactly
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import org.slf4j.LoggerFactory

class ClientOrderServiceImplTest {

    val clientService: ClientService = mockk()
    val orderService: OrderService = mockk()
    val emailService: EmailService = mockk()

    val logger = LoggerFactory.getLogger(this::class.java)

    val service = ClientOrderServiceImpl(
        clientService = clientService,
        orderService = orderService,
        emailService = emailService,
        logger = logger
    )

    @Test
    fun `getAllClientWithOrders`() = runBlocking {
        val client =
            ClientDto(id = 1, name = "test", age = 32, address = AddressDto(1, "street", "city", "state", "zip"))
        val clients = listOf(client)
        val order = Order(1, "order1", 123, 1)
        val orders = listOf(order)
        coEvery { clientService.getAllClients() } returns clients
        coEvery { orderService.getOrders() } returns orders
        val clientOrders = listOf(ClientOrderDto(clientDto = client, listOf(order.toOrderDto())))
        service.getAllClientWithOrders().shouldContainExactly(clientOrders)
    }

}