package br.com.arthurfnsc.bandsapi.configs.security.oauth2

import br.com.arthurfnsc.bandsapi.configs.AppProperties
import br.com.arthurfnsc.bandsapi.configs.security.oauth2.HttpCookieOAuth2AuthorizationRequestRepository.Companion.REDIRECT_URI_PARAM_COOKIE_NAME
import br.com.arthurfnsc.bandsapi.exceptions.BadRequestException
import br.com.arthurfnsc.bandsapi.services.TokenProviderService
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction.authentication
import org.springframework.web.util.UriComponentsBuilder
import org.springframework.util.ClassUtils.isPresent
import br.com.arthurfnsc.bandsapi.utils.CookieUtils
import javax.servlet.http.Cookie
import sun.print.CUPSPrinter.getPort
import java.net.URI


class OAuth2AuthenticationSuccessHandler(
    private val tokenProviderService: TokenProviderService,
    private val appProperties: AppProperties,
    private val httpCookieOAuth2: HttpCookieOAuth2AuthorizationRequestRepository
) : SimpleUrlAuthenticationSuccessHandler() {

    private fun clearAuthenticationAttributes(request: HttpServletRequest, response: HttpServletResponse) {

        super.clearAuthenticationAttributes(request)

        this.httpCookieOAuth2.removeAuthorizationRequestCookies(request, response)
    }

    private fun determineTargetUrl(request: HttpServletRequest, response: HttpServletResponse, authentication: Authentication): String {
        val redirectUri = CookieUtils.getCookie(request, REDIRECT_URI_PARAM_COOKIE_NAME)
            .map(Cookie::getValue)

        if (redirectUri.isPresent && !isAuthorizedRedirectUri(redirectUri.get())) {
            throw BadRequestException("Sorry! We've got an Unauthorized Redirect URI and can't proceed with the authentication")
        }

        val targetUrl = redirectUri.orElse(defaultTargetUrl)

        val token = this.tokenProviderService.createToken(authentication)

        return UriComponentsBuilder.fromUriString(targetUrl)
            .queryParam("token", token)
            .build().toUriString()
    }

    private fun isAuthorizedRedirectUri(uri: String): Boolean {

        val clientRedirectUri = URI.create(uri)

        return appProperties.oauth2.authorizedRedirectUris
            .stream()
            .anyMatch { authorizedRedirectUri ->

                // Only validate host and port. Let the clients use different paths if they want to
                val authorizedURI = URI.create(authorizedRedirectUri)

                if (authorizedURI.host.equals(clientRedirectUri.host, ignoreCase = true) && authorizedURI.port == clientRedirectUri.port) {

                    true
                }

                false
            }
    }

    override fun onAuthenticationSuccess(request: HttpServletRequest, response: HttpServletResponse, authentication: Authentication) {

        val targetUrl = determineTargetUrl(request, response, authentication)

        if (response.isCommitted) {
            logger.debug("Response has already been committed. Unable to redirect to \$targetUrl")
            return
        }

        clearAuthenticationAttributes(request, response)
        redirectStrategy.sendRedirect(request, response, targetUrl)
    }
}
