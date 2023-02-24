package cz.hammermantuts.kotlincoroutinewithspring.service

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class EmailServiceImpl(
    private val javaEmailSender: JavaMailSender,
    private val defaultCoroutineScope: CoroutineScope,
) : EmailService {
    override suspend fun sendEmail(to: String, subject: String, message: String) {
        defaultCoroutineScope.launch(Dispatchers.IO) {
            val mailMessage = SimpleMailMessage()
            mailMessage.setTo(to)
            mailMessage.subject = subject
            mailMessage.text = message
            javaEmailSender.send(mailMessage)
        }
    }
}