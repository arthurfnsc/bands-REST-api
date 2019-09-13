package br.com.arthurfnsc.bandsapi.configs

import br.com.arthurfnsc.bandsapi.configs.security.oauth2.HttpCookieOAuth2AuthorizationRequestRepository
import br.com.arthurfnsc.bandsapi.configs.security.oauth2.OAuth2AuthenticationFailureHandler
import br.com.arthurfnsc.bandsapi.configs.security.oauth2.OAuth2AuthenticationSuccessHandler
import br.com.arthurfnsc.bandsapi.configs.security.RestAuthenticationEntryPoint
import br.com.arthurfnsc.bandsapi.configs.security.oauth2.CustomOAuth2UserService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy


@Configuration
@EnableGlobalMethodSecurity(
    securedEnabled = true,
    jsr250Enabled = true,
    prePostEnabled = true
)
@EnableWebSecurity
@PropertySource("classpath:application.yml")
class SecurityConfig(
    private val cookieAuthorizationRequestRepository: HttpCookieOAuth2AuthorizationRequestRepository,
    private val oAuth2UserService: CustomOAuth2UserService,
    private val failureHandler: OAuth2AuthenticationFailureHandler,
    private val successHandler: OAuth2AuthenticationSuccessHandler
) : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {

        http
            .cors()
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .csrf()
            .disable()
            .formLogin()
            .disable()
            .httpBasic()
            .disable()
            .exceptionHandling()
            .authenticationEntryPoint(RestAuthenticationEntryPoint())
            .and()
            .authorizeRequests()
            .antMatchers("/auth/**", "/oauth2/**", "/swagger-resources/**", "/swagger-ui.html", "/v2/api-docs", "/webjars/**")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .oauth2Login()
            .authorizationEndpoint()
            .baseUri("/oauth2/authorize")
            .authorizationRequestRepository(cookieAuthorizationRequestRepository)
            .and()
            .redirectionEndpoint()
            .baseUri("/oauth2/callback/*")
            .and()
            .userInfoEndpoint()
            .userService(oAuth2UserService)
            .and()
            .successHandler(successHandler)
            .failureHandler(failureHandler)
    }
}
