package org.example.hexagonalarchitecture.api.infrastructure

import org.example.hexagonalarchitecture.api.domain.Api
import org.example.hexagonalarchitecture.api.service.outport.ApiRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class ApiRepositoryImpl(
    private val jpaRepository: ApiJpaRepository,
) : ApiRepository {

    override fun save(api: Api): Api {
        return jpaRepository.save(ApiEntity.fromDomain(api)).toDomain()
    }

    override fun findById(id: Long): Api {
        return jpaRepository.findByIdOrNull(id)?.toDomain() ?: throw RuntimeException("조회 실패")
    }

    override fun deleteAll() {
        jpaRepository.deleteAll()
    }
}