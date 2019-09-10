package br.com.arthurfnsc.bandsapi.configs

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.OAuthBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.AuthorizationCodeGrant
import springfox.documentation.service.AuthorizationScope
import springfox.documentation.service.GrantType
import springfox.documentation.service.SecurityReference
import springfox.documentation.service.SecurityScheme
import springfox.documentation.service.TokenEndpoint
import springfox.documentation.service.TokenRequestEndpoint
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spi.service.contexts.SecurityContext
import springfox.documentation.spring.web.plugins.Docket

@Configuration
class SwaggerConfig {

    @Value("\${spring.security.oauth2.client.registration.google.clientId}")
    lateinit var clientId: String

    @Value("\${spring.security.oauth2.client.registration.google.clientSecret}")
    lateinit var clientSecret: String

    companion object {

        const val SECURITY_SCHEMA_OAUTH = "oAuth2AuthCode"
        const val TOKEN_NAME = "oauth_token"
        const val TOKEN_URL = "https://www.googleapis.com/oauth2/v4/token"
        const val USER_AUTHORIZATION_URI = "https://accounts.google.com/o/oauth2/v2/auth"
    }

    fun apiInfo(): ApiInfo {

        val description = StringBuilder("")

        return ApiInfoBuilder()
            .title("Bands API")
            .description(description.toString())
            .version("1.0.0")
            .build()
    }

    private fun grantTypes(): List<GrantType> {

        val tokenRequestEndpoint = TokenRequestEndpoint(USER_AUTHORIZATION_URI, clientId, clientSecret)
        val tokenEndpoint = TokenEndpoint(TOKEN_URL, TOKEN_NAME)

        val grantType = AuthorizationCodeGrant(tokenRequestEndpoint, tokenEndpoint)

        return listOf(grantType)
    }

    private fun scopes(): List<AuthorizationScope> =
        listOf(
            AuthorizationScope(
                "email",
                "This scope requests that your app be given access to 1) the " +
                    "user's Google account email address. You access the " +
                    "email address by calling people.get, which returns " +
                    "the emails array (or by calling people.getOpenIdConnect, " +
                    "which returns the email property in OIDC-compliant " +
                    "format);  2) the name of the Google Apps domain, if " +
                    "any, that the user belongs to. The domain name is " +
                    "returned as the domain property from people.get (or " +
                    "hd property from getOpenIdConnect)."),
            AuthorizationScope(
                "openid",
                "This scope informs the authorization server that the client " +
                    "is making an OpenID Connect request, and requests access " +
                    "to the authenticated user’s ID. You must include this " +
                    "scope with the other OpenID Connect scopes. The " +
                    "getOpenIdConnect method returns the user's profile in " +
                    "OIDC-compliant format—use the following HTTP request " +
                    "path " +
                    "https://www.googleapis.com/plus/v1/people/me/openIdConnect"),
            AuthorizationScope(
                "profile",
                "This is the basic login scope. This scope does the " +
                    "following 1) It requests that your app be given access " +
                    "to the authenticated user's basic profile information; " +
                    "2) It lets you know who the currently authenticated user " +
                    "is by letting you replace a Google+ user ID with 'me', " +
                    "which represents the authenticated user, in any call to " +
                    "the Google+ API; 3) It lets your web app access " +
                    "over-the-air Android app installs."))

    private fun securityContext(): List<SecurityContext> =
        listOf(SecurityContext
            .builder()
            .securityReferences(securityReferences())
            .forPaths(PathSelectors.ant("/v1/bands/**"))
            .build())

    private fun securityReferences(): List<SecurityReference> =
        listOf(SecurityReference(SECURITY_SCHEMA_OAUTH, scopes().toTypedArray()))

    @Bean
    fun docket(): Docket = Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("br.com.arthurfnsc.bandsapi.apis.impl"))
        .paths(PathSelectors.any())
        .build()
        .securitySchemes(oauth())
        .securityContexts(securityContext())
        .apiInfo(apiInfo())

    @Bean
    fun oauth(): List<SecurityScheme> =
        listOf(OAuthBuilder()
            .name(SECURITY_SCHEMA_OAUTH)
            .grantTypes(grantTypes())
            .scopes(scopes())
            .build())
}
