package cz.hammermantuts.kotlincoroutinewithspring.handler


import cz.hammermantuts.kotlincoroutinewithspring.domain.EmailRequest
import cz.hammermantuts.kotlincoroutinewithspring.service.EmailService
import kotlinx.coroutines.reactive.awaitFirst
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.buildAndAwait

@Component
class EmailHandlerImpl(
    private val emailService: EmailService
) : EmailHandler {
    override suspend fun handle(request: ServerRequest): ServerResponse {
        val request = request.bodyToMono(EmailRequest::class.java).awaitFirst()
        emailService.sendEmail(request.to, request.subject, request.message)
        return ok().buildAndAwait()
    }
}

interface EmailHandler {
    suspend fun handle(request: ServerRequest): ServerResponse
}