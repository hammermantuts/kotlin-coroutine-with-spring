package cz.hammermantuts.kotlincoroutinewithspring.domain

data class ClientDto(
    val id: Long,
    val name: String,
    val age: Int,
    val address: AddressDto? = null
)

data class AddressDto(
    val id: Long,
    val street: String,
    val city: String,
    val state: String,
    val zip: String
)

data class ClientOrderDto(
    val clientDto: ClientDto,
    val orderDtoList: List<OrderDto>,
)

