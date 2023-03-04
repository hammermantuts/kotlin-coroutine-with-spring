package cz.hammermantuts.kotlincoroutinewithspring.service

import cz.hammermantuts.kotlincoroutinewithspring.domain.ClientDto
import cz.hammermantuts.kotlincoroutinewithspring.domain.OrderDto

interface EmailService {
    suspend fun sendEmail(to: String, subject: String, message: String)
    suspend fun sendOrderConfirmationEmail(to: String, client: ClientDto, order: OrderDto)
}