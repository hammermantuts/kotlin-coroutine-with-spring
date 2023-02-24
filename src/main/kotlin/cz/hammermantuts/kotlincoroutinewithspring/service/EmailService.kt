package cz.hammermantuts.kotlincoroutinewithspring.service

interface EmailService {
    suspend fun sendEmail(to: String, subject: String, message: String)
}