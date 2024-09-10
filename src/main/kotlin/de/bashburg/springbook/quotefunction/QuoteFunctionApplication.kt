package de.bashburg.springbook.quotefunction

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class QuoteFunctionApplication

fun main(args: Array<String>) {
    runApplication<QuoteFunctionApplication>(*args)
}
