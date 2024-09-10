package de.bashburg.springbook.quotefunction.domain

data class Quote(
    val content: String,
    val author: String,
    val genre: Genre
)
