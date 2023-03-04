package cz.hammermantuts.kotlincoroutinewithspring.domain

data class CreateClientOrderDto(
    val to: String,
    val clientId: Long,
    val orderName : String,
)

data class OrderDto(
    val id: Long,
    val clientId: Long,
    val orderName : String,
    val orderNumber: Long,
)