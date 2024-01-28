package org.example.hexagonalarchitecture.api.controller

import org.example.hexagonalarchitecture.api.domain.ApiCreate
import org.example.hexagonalarchitecture.api.domain.ApiResponse
import org.example.hexagonalarchitecture.api.domain.ApiUpdate
import org.example.hexagonalarchitecture.api.service.ApiService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ApiController(
    private val apiService: ApiService,
) {

    @PostMapping("/api")
    fun save(@RequestBody apiCreate: ApiCreate): ResponseEntity<ApiResponse> {
        val api = apiService.save(apiCreate)
        return ResponseEntity.ok()
                    .body(ApiResponse.of(api))
    }

    @PatchMapping("/api/{id}")
    fun update(@PathVariable id: Long, @RequestBody apiUpdate: ApiUpdate): ResponseEntity<ApiResponse> {
        val api = apiService.update(id, apiUpdate)
        return ResponseEntity.ok()
            .body(ApiResponse.of(api))
    }



}