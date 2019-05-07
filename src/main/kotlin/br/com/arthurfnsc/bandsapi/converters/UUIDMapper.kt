package br.com.arthurfnsc.bandsapi.converters

import java.util.UUID
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
open class UUIDMapper {

    fun convert(element: String): UUID =
        UUID.fromString(element)

    fun convert(element: UUID): String =
        element.toString()
}
