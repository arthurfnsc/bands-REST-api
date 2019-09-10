package br.com.arthurfnsc.bandsapi.configs.security

import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

class RestAuthenticationEntryPoint : AuthenticationEntryPoint {

    @Throws(IOException::class, ServletException::class)
    override fun commence(httpServletRequest: HttpServletRequest,
                          httpServletResponse: HttpServletResponse,
                          e: AuthenticationException) {

        println("=> <=")
        logger.error("Responding with unauthorized error. Message - {}", e.message)
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                e.getLocalizedMessage())
    }

    companion object {

        private val logger = LoggerFactory.getLogger(RestAuthenticationEntryPoint::class.java)
    }
}