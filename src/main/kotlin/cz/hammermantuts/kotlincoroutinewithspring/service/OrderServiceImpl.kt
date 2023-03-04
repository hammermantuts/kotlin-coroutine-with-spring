package cz.hammermantuts.kotlincoroutinewithspring.service

import cz.hammermantuts.kotlincoroutinewithspring.domain.CreateClientOrderDto
import cz.hammermantuts.kotlincoroutinewithspring.entity.Order
import cz.hammermantuts.kotlincoroutinewithspring.repository.OrderRepository
import kotlinx.coroutines.flow.toList
import org.slf4j.Logger
import org.springframework.stereotype.Service
import java.util.*

@Service
class OrderServiceImpl(
    private val orderRepository: OrderRepository,
    private val logger: Logger,
) : OrderService {
    override suspend fun getOrders(): List<Order> {
        return orderRepository.findAll().toList()
    }

    override suspend fun createOrder(order: CreateClientOrderDto): Order {
        logger.info("Create order for client ${order.clientId}")
        return orderRepository.save(
            Order(
                orderNumber = Random().nextLong(1, 1_000_000),
                orderName = order.orderName,
                clientId = order.clientId,
                id = null,
            )
        )
    }
}