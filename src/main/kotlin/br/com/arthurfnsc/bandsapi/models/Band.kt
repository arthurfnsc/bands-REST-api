package br.com.arthurfnsc.bandsapi.models

import java.time.LocalDate

data class Band(
        var id: String? = null,
        var name: String? = null,
        var status: BandStatus? = null,
        var creation: LocalDate? = null,
        var members: Set<Member> = setOf(),
        var creationedAt: LocalDate? = null,
        var updatedAt: LocalDate? = null
)
