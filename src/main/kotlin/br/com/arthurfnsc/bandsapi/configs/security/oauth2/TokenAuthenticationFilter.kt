package br.com.arthurfnsc.bandsapi.configs.security.oauth2

import br.com.arthurfnsc.bandsapi.configs.security.services.CustomUserDetailsService
import br.com.arthurfnsc.bandsapi.configs.security.services.TokenProviderService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.util.StringUtils
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class TokenAuthenticationFilter : OncePerRequestFilter() {

    @Autowired
    private val tokenProvider: TokenProviderService? = null

    @Autowired
    private val customUserDetailsService: CustomUserDetailsService? = null

    @Throws(ServletException::class, IOException::class)
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, filterChain: FilterChain) {
        try {
            val jwt = getJwtFromRequest(request)!!

            if (StringUtils.hasText(jwt) && tokenProvider!!.validateToken(jwt)) {
                val userId = tokenProvider!!.getUserIdFromToken(jwt)

                val userDetails = customUserDetailsService!!.loadUserById(userId)
                val authentication = UsernamePasswordAuthenticationToken(userDetails, null, userDetails.authorities)
                authentication.details = WebAuthenticationDetailsSource().buildDetails(request)

                SecurityContextHolder.getContext().authentication = authentication
            }
        } catch (ex: Exception) {
            logger.error("Could not set user authentication in security context", ex)
        }

        filterChain.doFilter(request, response)
    }

    private fun getJwtFromRequest(request: HttpServletRequest): String? {
        val bearerToken = request.getHeader("Authorization")
        return if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            bearerToken.substring(7, bearerToken.length)
        } else null
    }

    companion object {

        private val logger = LoggerFactory.getLogger(TokenAuthenticationFilter::class.java)
    }
}
