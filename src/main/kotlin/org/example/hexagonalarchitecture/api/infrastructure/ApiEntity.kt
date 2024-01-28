package org.example.hexagonalarchitecture.api.infrastructure

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.example.hexagonalarchitecture.api.domain.Api
import org.hibernate.annotations.Comment

@Entity
class ApiEntity constructor(

    @Comment("API명, API 패키지명")
    var apiName: String,

    @Comment("프로젝트 ID")
    val projectId: Long,

    @Comment("API ID")
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) {

    companion object {
        // 도메인 객체를 엔티티 객체로 변환
        fun fromDomain(api: Api): ApiEntity {
            return ApiEntity(
                apiName = api.apiName,
                projectId = api.projectId,
                id = api.id
            )
        }
    }

    // 엔티티 객체를 도메인 객체로 변환
    fun toDomain(): Api {
        return Api(
            apiName = this.apiName,
            projectId = this.projectId,
            id = this.id
        )
    }
}