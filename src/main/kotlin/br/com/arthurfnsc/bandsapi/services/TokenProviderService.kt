package br.com.arthurfnsc.bandsapi.services

import br.com.arthurfnsc.bandsapi.configs.AppProperties
import br.com.arthurfnsc.bandsapi.configs.security.UserPrincipal
import io.jsonwebtoken.*
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.*


@Service
class TokenProviderService(
    private val appProperties: AppProperties
) {

    fun createToken(authentication: Authentication): String {
        val userPrincipal = authentication.getPrincipal() as UserPrincipal

        val instant: Instant = Instant.now()

        val now = Date.from(instant)
        val expiryDate = Date(now.getTime() + appProperties.auth.tokenExpirationMsec)

        return Jwts.builder()
            .setSubject(userPrincipal.id.toString())
            .setIssuedAt(now)
            .setExpiration(expiryDate)
            .signWith(SignatureAlgorithm.HS512, appProperties.auth.tokenSecret)
            .compact()
    }

    fun getUserIdFromToken(token: String?): Long? {
        val claims = Jwts.parser()
            .setSigningKey(appProperties.auth.tokenSecret)
            .parseClaimsJws(token)
            .body

        return java.lang.Long.parseLong(claims.subject)
    }

    fun validateToken(authToken: String?): Boolean {

        try {
            Jwts.parser().setSigningKey(appProperties.auth.tokenSecret).parseClaimsJws(authToken)
            return true
        } catch (ex: SignatureException) {
            //logger.error("Invalid JWT signature")
        } catch (ex: MalformedJwtException) {
            //logger.error("Invalid JWT token")
        } catch (ex: ExpiredJwtException) {
            //logger.error("Expired JWT token")
        } catch (ex: UnsupportedJwtException) {
            //logger.error("Unsupported JWT token")
        } catch (ex: IllegalArgumentException) {
            //logger.error("JWT claims string is empty.")
        }

        return false
    }
}
