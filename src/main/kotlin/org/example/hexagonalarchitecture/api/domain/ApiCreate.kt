package org.example.hexagonalarchitecture.api.domain

data class ApiCreate constructor(
    var apiName: String,
    val projectId: Long,
)