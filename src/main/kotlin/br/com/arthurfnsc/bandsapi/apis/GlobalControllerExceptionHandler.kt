package br.com.arthurfnsc.bandsapi.apis

import org.springframework.context.MessageSource
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@RestControllerAdvice
class GlobalControllerExceptionHandler(private val messageSource: MessageSource) : ResponseEntityExceptionHandler()
