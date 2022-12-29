package com.hddev.aishopcore

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication
class AIShopCoreApplication

fun main(args: Array<String>) {
	runApplication<AIShopCoreApplication>(*args)
}
