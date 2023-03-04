package cz.hammermantuts.kotlincoroutinewithspring.repository

import cz.hammermantuts.kotlincoroutinewithspring.entity.Order
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface OrderRepository: CoroutineCrudRepository<Order,Long> {
}