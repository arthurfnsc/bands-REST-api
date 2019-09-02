package br.com.arthurfnsc.bandsapi.properties

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit4.SpringRunner

@ContextConfiguration(classes = [PropertiesComponent::class])
@RunWith(SpringRunner::class)
@SpringBootTest
@TestPropertySource(
    properties = [
        "GOOGLE_CLIENT_ID = 123",
        "GOOGLE_CLIENT_SECRET = 456"
    ]
)
class PropertiesComponentTest {

    @Autowired
    lateinit var propertiesComponent: PropertiesComponent

    @Test
    fun `validate clientId`() {

        val clientId = propertiesComponent.clientId

        assertEquals("123", clientId)
    }

    @Test
    fun `validate clientSecret`() {

        val clientSecret = propertiesComponent.clientSecret

        assertEquals("456", clientSecret)
    }
}
