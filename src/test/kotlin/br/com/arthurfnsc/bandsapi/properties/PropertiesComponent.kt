package br.com.arthurfnsc.bandsapi.properties

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class PropertiesComponent {

    @Value("\${spring.security.oauth2.client.registration.google.client-id}")
    lateinit var clientId: String

    @Value("\${spring.security.oauth2.client.registration.google.client-secret}")
    lateinit var clientSecret: String
}
