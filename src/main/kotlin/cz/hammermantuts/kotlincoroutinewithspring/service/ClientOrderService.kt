package cz.hammermantuts.kotlincoroutinewithspring.service

import cz.hammermantuts.kotlincoroutinewithspring.domain.ClientOrderDto
import cz.hammermantuts.kotlincoroutinewithspring.domain.CreateClientOrderDto

interface ClientOrderService {
    suspend fun getAllClientWithOrders(): List<ClientOrderDto>
    suspend fun confirmAndSendOrder(request: CreateClientOrderDto)
}