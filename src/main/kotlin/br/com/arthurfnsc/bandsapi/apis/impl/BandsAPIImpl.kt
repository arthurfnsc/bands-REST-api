package br.com.arthurfnsc.bandsapi.apis.impl

import br.com.arthurfnsc.bandsapi.converters.BandMapper
import br.com.arthurfnsc.bandsapi.converters.MemberMapper
import br.com.arthurfnsc.bandsapi.services.BandService
import br.com.arthurfnsc.bandsapi.services.MemberService
import com.fasterxml.jackson.databind.ObjectMapper
import org.openapitools.api.V1Api
import org.openapitools.model.Band
import org.openapitools.model.PatchDocument
import org.openapitools.model.RequestPostBand
import org.openapitools.model.RequestPostBandMember
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RestController
import java.util.*

@CrossOrigin(origins = ["*"])
@RestController
class BandsAPIImpl(
        private val objectMapper: ObjectMapper,
        private val bandMapper: BandMapper,
        private val memberMapper: MemberMapper,
        private val bandService: BandService,
        private val memberService: MemberService
): V1Api {

    override fun createBand(requestPostBand: RequestPostBand?): ResponseEntity<Band> {
        return super.createBand(requestPostBand)
    }

    override fun createBandMember(bandId: UUID?, requestPostBandMember: RequestPostBandMember?): ResponseEntity<Band> {
        return super.createBandMember(bandId, requestPostBandMember)
    }

    override fun deleteBand(bandId: UUID?): ResponseEntity<Void> {

        this.bandService.deleteById(bandId.toString())

        return ResponseEntity(HttpStatus.OK)
    }

    override fun deleteBandMember(bandId: UUID?, memberId: UUID?): ResponseEntity<Band> {
        return super.deleteBandMember(bandId, memberId)
    }

    override fun retrieveBands(): ResponseEntity<MutableList<Band>> {

        val response = this.bandMapper.convert(this.bandService.findAll())

        return ResponseEntity(
                response.map {
                    this.objectMapper.convertValue<Band>(it, Band::class.java)
                },
                HttpStatus.OK)
    }

    override fun updateBand(bandId: UUID?, patchDocument: MutableList<PatchDocument>?): ResponseEntity<Band> {
        return super.updateBand(bandId, patchDocument)
    }
}