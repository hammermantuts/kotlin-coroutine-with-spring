package cz.hammermantuts.kotlincoroutinewithspring.repository

import cz.hammermantuts.kotlincoroutinewithspring.entity.Address
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface AddressRepository : ReactiveCrudRepository<Address, Long> {
    suspend fun findAddressByClientId(clientId: Long): Address
}