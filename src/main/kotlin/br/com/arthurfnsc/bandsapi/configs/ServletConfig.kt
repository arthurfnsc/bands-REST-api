package br.com.arthurfnsc.bandsapi.configs

import org.apache.tomcat.util.http.LegacyCookieProcessor
import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory
import org.springframework.boot.web.server.WebServerFactoryCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class ServletConfig: WebMvcConfigurer {

    @Bean
    fun cookieProcessorCustomizer(): WebServerFactoryCustomizer<TomcatServletWebServerFactory> {
        return WebServerFactoryCustomizer { tomcatServletWebServerFactory ->
            tomcatServletWebServerFactory.addContextCustomizers(TomcatContextCustomizer { context -> context.cookieProcessor = LegacyCookieProcessor() })
        }
    }
}