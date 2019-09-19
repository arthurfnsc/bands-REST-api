package br.com.arthurfnsc.bandsapi.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class ResourceNotFoundException(
    private val resourceName: String,
    private val fieldName: String,
    private val fieldValue: Any
) : RuntimeException(
    String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue)
)
