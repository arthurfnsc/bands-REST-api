package br.com.arthurfnsc.bandsapi.services

import br.com.arthurfnsc.bandsapi.models.Band
import com.google.common.collect.ImmutableList
import org.springframework.stereotype.Service

@Service
class BandService {

    fun deleteById(id: String) {}

    fun findAll(): ImmutableList<Band> =
        ImmutableList.of()
}
