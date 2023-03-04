package cz.hammermantuts.kotlincoroutinewithspring.extension

import cz.hammermantuts.kotlincoroutinewithspring.domain.AddressDto
import cz.hammermantuts.kotlincoroutinewithspring.domain.ClientDto
import cz.hammermantuts.kotlincoroutinewithspring.domain.OrderDto
import cz.hammermantuts.kotlincoroutinewithspring.entity.Address
import cz.hammermantuts.kotlincoroutinewithspring.entity.Client
import cz.hammermantuts.kotlincoroutinewithspring.entity.Order

object Mapper {
    fun Order.toOrderDto(): OrderDto {
        return OrderDto(this.id!!, this.clientId!!, this.orderName, this.orderNumber)
    }

    fun Client.toClientDto(): ClientDto {
        return ClientDto(this.id!!, this.name, this.age, this.address?.toAddressDto())
    }

    fun Address.toAddressDto(): AddressDto {
        return AddressDto(this.id!!, this.street, this.city, this.state, this.zip)
    }
}