package cz.hammermantuts.kotlincoroutinewithspring.service

import cz.hammermantuts.kotlincoroutinewithspring.domain.ClientDto
import cz.hammermantuts.kotlincoroutinewithspring.entity.Client
import kotlinx.coroutines.flow.Flow

interface ClientService {
    suspend fun getClientById(id: Long): Client
    suspend fun getAllClients(): List<ClientDto>
}