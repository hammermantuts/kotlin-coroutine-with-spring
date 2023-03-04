package cz.hammermantuts.kotlincoroutinewithspring.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table(name = "client")
data class Client(
    @Id
    var id: Long?,
    var name: String,
    var age: Int,

    @Transient var address: Address?
)

@Table(name = "address")
data class Address(
    @Id
    var id: Long?,
    var street: String,
    var city: String,
    var state: String,
    var zip: String,
    @Column("client_id") val clientId: Long?
)

@Table(name = "order_t")
data class Order(
    @Id
    var id: Long?,
    var orderName: String,
    var orderNumber: Long,
    @Column("client_id") val clientId: Long?
)