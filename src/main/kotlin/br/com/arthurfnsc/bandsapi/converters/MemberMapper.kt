package br.com.arthurfnsc.bandsapi.converters

import br.com.arthurfnsc.bandsapi.models.Member
import org.mapstruct.Mapper
import org.mapstruct.Mappings

@Mapper(
    componentModel = "spring",
    uses = [
        UUIDMapper::class
    ]
)
interface MemberMapper {

    @Mappings
    fun convert(element: Member): org.openapitools.model.Member

    fun convert(elements: List<Member>): List<org.openapitools.model.Member>
}
