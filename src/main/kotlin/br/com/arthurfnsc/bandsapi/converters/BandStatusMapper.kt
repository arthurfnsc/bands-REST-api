package br.com.arthurfnsc.bandsapi.converters

import br.com.arthurfnsc.bandsapi.models.BandStatus
import org.mapstruct.Mapper
import org.mapstruct.ValueMapping
import org.mapstruct.ValueMappings

@Mapper(componentModel = "spring")
interface BandStatusMapper {

    @ValueMappings(
        ValueMapping(source = "BREAK_UP", target = "BREAK_UP"),
        ValueMapping(source = "HIATUS", target = "HIATUS"),
        ValueMapping(source = "ON_THE_ROAD", target = "ON_THE_ROAD")
    )
    fun convert(element: BandStatus): org.openapitools.model.BandStatus

    @ValueMappings(
        ValueMapping(source = "BREAK_UP", target = "BREAK_UP"),
        ValueMapping(source = "HIATUS", target = "HIATUS"),
        ValueMapping(source = "ON_THE_ROAD", target = "ON_THE_ROAD")
    )
    fun convert(element: org.openapitools.model.BandStatus): BandStatus
}
