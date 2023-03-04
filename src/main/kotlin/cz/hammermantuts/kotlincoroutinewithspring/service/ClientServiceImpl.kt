package cz.hammermantuts.kotlincoroutinewithspring.service

import cz.hammermantuts.kotlincoroutinewithspring.domain.AddressDto
import cz.hammermantuts.kotlincoroutinewithspring.domain.ClientDto
import cz.hammermantuts.kotlincoroutinewithspring.entity.Client
import cz.hammermantuts.kotlincoroutinewithspring.repository.AddressRepository
import cz.hammermantuts.kotlincoroutinewithspring.repository.ClientRepository
import kotlinx.coroutines.flow.toList
import org.slf4j.Logger
import org.springframework.stereotype.Service
import cz.hammermantuts.kotlincoroutinewithspring.domain.ClientDto as DomainClient


@Service
class ClientServiceImpl(
    private val clientRepository: ClientRepository,
    private val addressRepository: AddressRepository,
    private val logger: Logger
) : ClientService {

    override suspend fun getClientById(id: Long): Client {
        logger.info("Find client by id: $id")
        return clientRepository.findById(id) ?: error("Client with id:$id not found")
    }

    override suspend fun getAllClients(): List<ClientDto> {
        return clientRepository.findAll().toList().map {
            DomainClient(
                it.id!!,
                it.name,
                it.age,
                addressDto = addressRepository.findAddressByClientId(it.id!!)
                    .let { a -> AddressDto(a.id!!, a.street, a.city, a.state, a.zip) }
            )
        }
    }
}