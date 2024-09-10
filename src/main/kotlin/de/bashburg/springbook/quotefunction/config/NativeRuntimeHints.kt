package de.bashburg.springbook.quotefunction.config

import de.bashburg.springbook.quotefunction.domain.Quote
import org.springframework.aot.hint.RuntimeHints
import org.springframework.aot.hint.RuntimeHintsRegistrar
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding
import org.springframework.context.annotation.Configuration

@Configuration
@RegisterReflectionForBinding(Quote::class)
class NativeRuntimeHints : RuntimeHintsRegistrar {
    override fun registerHints(hints: RuntimeHints, classLoader: ClassLoader?) {
    }
}
