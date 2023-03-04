package cz.hammermantuts.kotlincoroutinewithspring.service

import cz.hammermantuts.kotlincoroutinewithspring.domain.CreateClientOrderDto
import cz.hammermantuts.kotlincoroutinewithspring.entity.Order

interface OrderService {
    suspend fun getOrders(): List<Order>
    suspend fun createOrder(order: CreateClientOrderDto): Order
}