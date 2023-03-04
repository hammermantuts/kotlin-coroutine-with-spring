import org.junit.jupiter.api.Test

class Test {
    @Test
    fun t() {
        val clients = listOf(
            Client(1, "John Smith"),
            Client(2, "Jane Doe"),
            Client(3, "Bob Johnson")
        )

        val orders = listOf(
            Order(1, "ORD-123"),
            Order(2, "ORD-456"),
            Order(2, "ORD-789"),
            Order(3, "ORD-987")
        )

        val clientOrdersMap = orders.groupBy { it.clientId }
        val clientsWithOrders = clients.map { client ->
            ClientOrder(client, clientOrdersMap[client.id] ?: emptyList())
        }

        clientsWithOrders.forEach { it ->
            println("${it.client.name} has ${it.orders.size} order(s): ${it.orders.joinToString { it.orderNumber }}")
        }
    }
}

data class Client(val id: Int, val name: String)
data class Order(val clientId: Int, val orderNumber: String)

data class ClientOrder(val client: Client,val orders: List<Order>)