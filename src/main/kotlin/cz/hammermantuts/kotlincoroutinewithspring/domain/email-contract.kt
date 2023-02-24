package cz.hammermantuts.kotlincoroutinewithspring.domain

data class EmailRequest(
    val to: String,
    val subject: String,
    val message: String
)
