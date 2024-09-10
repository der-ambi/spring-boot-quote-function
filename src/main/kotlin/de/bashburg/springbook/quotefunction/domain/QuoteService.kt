package de.bashburg.springbook.quotefunction.domain

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import kotlin.random.Random

@Service
class QuoteService {
    val random = Random.Default

    val quotes = listOf(
        Quote("Content A", "Abigail", Genre.ADVENTURE),
        Quote("Content B", "Beatrix", Genre.ADVENTURE),
        Quote("Content C", "Casper", Genre.FANTASY),
        Quote("Content D", "Dobby", Genre.FANTASY),
        Quote("Content E", "Eileen", Genre.SCIENCE_FICTION),
        Quote("Content F", "Flora", Genre.SCIENCE_FICTION)
    )

    fun getAllQuotes(): Flux<Quote> =
        Flux.fromIterable(quotes)


    fun getRandomQuote(): Mono<Quote> =
        Mono.just(quotes[random.nextInt(quotes.size)])


    fun getRandomQuoteByGenre(genre: Genre): Mono<Quote> {
        val quotesForGenre = quotes.stream()
            .filter { q -> q.genre == genre }
            .toList()
        return Mono.just(
            quotesForGenre[
                random.nextInt(quotesForGenre.size)]
        )
    }
}