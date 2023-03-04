package cz.hammermantuts.kotlincoroutinewithspring.service

import cz.hammermantuts.kotlincoroutinewithspring.domain.ClientDto
import cz.hammermantuts.kotlincoroutinewithspring.domain.OrderDto
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.slf4j.Logger
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class EmailServiceImpl(
    private val javaEmailSender: JavaMailSender,
    private val defaultCoroutineScope: CoroutineScope,
    private val logger: Logger,
) : EmailService {
    override suspend fun sendEmail(to: String, subject: String, message: String) {
        defaultCoroutineScope.launch {
            val mailMessage = SimpleMailMessage()
            mailMessage.setTo(to)
            mailMessage.subject = subject
            mailMessage.text = message
            javaEmailSender.send(mailMessage)
        }
    }

    override suspend fun sendOrderConfirmationEmail(to: String, client: ClientDto, order: OrderDto) {
        logger.info("Send notification to client: $to")
        defaultCoroutineScope.launch {
            val mailMessage = SimpleMailMessage()
            mailMessage.setTo(to)
            mailMessage.subject = "Order Confirmation"
            mailMessage.text =
                "Dear ${client.name},\n\nYour order with ID ${order.orderNumber} has been confirmed.\n\nThank you for shopping with us!"
            javaEmailSender.send(mailMessage)
        }
    }
}