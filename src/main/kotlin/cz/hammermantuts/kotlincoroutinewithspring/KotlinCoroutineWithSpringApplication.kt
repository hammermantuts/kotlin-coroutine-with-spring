package cz.hammermantuts.kotlincoroutinewithspring

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KotlinCoroutineWithSpringApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotlinCoroutineWithSpringApplication::class.java, *args)
}