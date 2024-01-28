package org.example.hexagonalarchitecture.api.service.outport

import org.example.hexagonalarchitecture.api.domain.Api

interface ApiRepository {
    fun save(api: Api): Api
    fun findById(id: Long): Api
    fun deleteAll()
}