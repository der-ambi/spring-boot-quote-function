package de.bashburg.springbook.quotefunction.functions

import de.bashburg.springbook.quotefunction.domain.Genre
import de.bashburg.springbook.quotefunction.domain.Quote
import de.bashburg.springbook.quotefunction.domain.QuoteService
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration

@Configuration
class QuoteFunctions(private val quoteService: QuoteService) {

    private val logger = KotlinLogging.logger {}

    @Bean
    fun allQuotes(): () -> Flux<Quote> =
        {
            logger.info { "Getting all quotes" }
            quoteService.getAllQuotes().delaySequence(Duration.ofSeconds(1))
        }

    @Bean
    fun randomQuote(): () -> Flux<Quote> =
        {
            logger.info { "Getting random quote" }
            quoteService.getRandomQuote().flux()
        }

    @Bean
    fun genreQuote(): (Mono<Genre>) -> Flux<Quote> =
        { genre ->
            genre.flatMap { quoteService.getRandomQuoteByGenre(it) }.flux()
        }

    @Bean
    fun logQuote(): (Quote) -> Unit =
        { quote ->
            logger.info { "Quote: '${quote.content}' by '${quote.author}'" }
        }
}