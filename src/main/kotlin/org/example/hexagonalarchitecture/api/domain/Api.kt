package org.example.hexagonalarchitecture.api.domain

data class Api constructor(
    var apiName: String,
    val projectId: Long,
    val id: Long? = null,
) {
    companion object {
        // 도메인 생성
        fun of(apiCreate: ApiCreate): Api {
            return Api(
                apiName = apiCreate.apiName,
                projectId = apiCreate.projectId,
            )
        }
    }

    // 비즈니스 로직 (업데이트)
    fun update(apiUpdate: ApiUpdate): Api {
        return Api(
            apiName = apiUpdate.apiName,
            projectId = projectId,
            id = id,
        )
    }
}