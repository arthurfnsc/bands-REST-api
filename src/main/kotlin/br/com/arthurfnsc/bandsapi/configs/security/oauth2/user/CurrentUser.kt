package br.com.arthurfnsc.bandsapi.configs.security.oauth2.user

import org.springframework.security.core.annotation.AuthenticationPrincipal
import java.lang.annotation.Documented

@Target(AnnotationTarget.FIELD, AnnotationTarget.TYPE)
@Retention(AnnotationRetention.RUNTIME)
@Documented
@AuthenticationPrincipal
annotation class CurrentUser