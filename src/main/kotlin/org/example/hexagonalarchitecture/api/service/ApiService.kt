package org.example.hexagonalarchitecture.api.service

import org.example.hexagonalarchitecture.api.domain.Api
import org.example.hexagonalarchitecture.api.domain.ApiCreate
import org.example.hexagonalarchitecture.api.domain.ApiUpdate
import org.example.hexagonalarchitecture.api.service.outport.ApiRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ApiService(
    private val apiRepository: ApiRepository,
) {

    @Transactional
    fun save(apiCreate: ApiCreate): Api {
        val api = Api.of(apiCreate)
        return apiRepository.save(api)
    }

    @Transactional
    fun update(id: Long, apiUpdate: ApiUpdate): Api {
        val api = apiRepository.findById(id)
        val updateApi = api.update(apiUpdate)
        return apiRepository.save(updateApi)
    }
}