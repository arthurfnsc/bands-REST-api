package br.com.arthurfnsc.bandsapi.converters

import br.com.arthurfnsc.bandsapi.models.Band
import org.mapstruct.Mapper
import org.mapstruct.Mappings

@Mapper(
    componentModel = "spring",
    uses = [
        BandStatusMapper::class,
        MemberMapper::class,
        UUIDMapper::class
    ]
)
interface BandMapper {

    @Mappings
    fun convert(element: Band): Band

    fun convert(elements: List<Band>): List<Band>
}
