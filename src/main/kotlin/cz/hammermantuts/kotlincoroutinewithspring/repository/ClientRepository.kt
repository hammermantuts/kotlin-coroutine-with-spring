package cz.hammermantuts.kotlincoroutinewithspring.repository

import cz.hammermantuts.kotlincoroutinewithspring.entity.Client
import kotlinx.coroutines.flow.Flow
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface ClientRepository: CoroutineCrudRepository<Client,Long> {
}