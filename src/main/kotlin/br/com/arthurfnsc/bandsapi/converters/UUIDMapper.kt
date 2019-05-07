package br.com.arthurfnsc.bandsapi.converters

import org.mapstruct.Mapper
import java.util.*

@Mapper(componentModel = "spring")
class UUIDMapper {

    fun convert(element: String): UUID =
            UUID.fromString(element)

    fun convert(element: UUID): String =
            element.toString()
}