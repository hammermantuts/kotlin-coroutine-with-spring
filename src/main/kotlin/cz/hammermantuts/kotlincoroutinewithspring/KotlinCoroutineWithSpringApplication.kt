package cz.hammermantuts.kotlincoroutinewithspring

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing

@SpringBootApplication
@EnableR2dbcAuditing
class KotlinCoroutineWithSpringApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotlinCoroutineWithSpringApplication::class.java, *args)
}