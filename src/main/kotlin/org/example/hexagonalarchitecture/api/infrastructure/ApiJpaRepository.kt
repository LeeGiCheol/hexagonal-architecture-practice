package org.example.hexagonalarchitecture.api.infrastructure

import org.springframework.data.jpa.repository.JpaRepository

interface ApiJpaRepository : JpaRepository<ApiEntity, Long> {
}