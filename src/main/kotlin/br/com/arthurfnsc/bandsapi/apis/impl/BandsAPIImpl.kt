package br.com.arthurfnsc.bandsapi.apis.impl

import br.com.arthurfnsc.bandsapi.converters.BandMapper
import br.com.arthurfnsc.bandsapi.converters.MemberMapper
import br.com.arthurfnsc.bandsapi.services.BandService
import br.com.arthurfnsc.bandsapi.services.MemberService
import com.fasterxml.jackson.databind.ObjectMapper
import java.util.UUID
import org.openapitools.api.V1Api
import org.openapitools.model.Band
import org.openapitools.model.PatchDocument
import org.openapitools.model.RequestPostBand
import org.openapitools.model.RequestPostBandMember
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RestController
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import java.security.Principal


@CrossOrigin(origins = ["*"])
@RestController
class BandsAPIImpl(
    private val objectMapper: ObjectMapper,
    private val bandMapper: BandMapper,
    private val memberMapper: MemberMapper,
    private val bandService: BandService,
    private val memberService: MemberService
) : V1Api {

    override fun createBand(requestPostBand: RequestPostBand?): ResponseEntity<Band> =
        super.createBand(requestPostBand)

    override fun createBandMember(bandId: UUID?, requestPostBandMember: RequestPostBandMember?): ResponseEntity<Band> =
        super.createBandMember(bandId, requestPostBandMember)

    override fun deleteBand(bandId: UUID?): ResponseEntity<Void> {

        this.bandService.deleteById(bandId.toString())

        return ResponseEntity(HttpStatus.OK)
    }

    override fun deleteBandMember(bandId: UUID?, memberId: UUID?): ResponseEntity<Band> =
        super.deleteBandMember(bandId, memberId)

    override fun retrieveBands(): ResponseEntity<List<Band>> {

        val response = this.bandMapper.convert(this.bandService.findAll())

        return ResponseEntity(
            response.map {
                this.objectMapper.convertValue<Band>(it, Band::class.java)
            },
            HttpStatus.OK
        )
    }

    override fun updateBand(bandId: UUID?, patchDocument: List<PatchDocument>?): ResponseEntity<Band> =
        super.updateBand(bandId, patchDocument)
}
