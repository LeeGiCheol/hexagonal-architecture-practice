package org.example.hexagonalarchitecture.api.domain

data class ApiResponse constructor(
    var apiName: String,
    val projectId: Long,
    val id: Long? = null,
) {

    companion object {
        fun of(api: Api): ApiResponse {
            return ApiResponse(
                id = api.id,
                apiName = api.apiName,
                projectId = api.projectId,
            )
        }
    }
}