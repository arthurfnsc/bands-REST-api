package br.com.arthurfnsc.bandsapi.configs

import org.springframework.context.MessageSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ReloadableResourceBundleMessageSource
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean

@Configuration
class I18nConfig {

    companion object {

        const val ENCODING = "UTF-8"
        const val MESSAGES_PATH = "classpath:i18n/messages"
    }

    @Bean
    fun validator(messageSource: MessageSource): LocalValidatorFactoryBean {

        val factory = LocalValidatorFactoryBean()
        factory.setValidationMessageSource(messageSource)

        return factory
    }

    @Bean
    fun messageSource(): MessageSource {

        val messageSource = ReloadableResourceBundleMessageSource()
        messageSource.setBasename(MESSAGES_PATH)
        messageSource.setDefaultEncoding(ENCODING)

        return messageSource
    }
}
