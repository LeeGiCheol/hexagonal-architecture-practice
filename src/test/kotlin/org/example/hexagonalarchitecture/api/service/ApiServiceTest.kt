package org.example.hexagonalarchitecture.api.service

import org.assertj.core.api.Assertions.assertThat
import org.example.hexagonalarchitecture.api.domain.ApiCreate
import org.example.hexagonalarchitecture.api.domain.ApiUpdate
import org.example.hexagonalarchitecture.api.service.outport.ApiRepository
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ApiServiceTest @Autowired constructor(
    private val apiService: ApiService,
    private val apiRepository: ApiRepository,
) {

    @AfterEach
    fun teardown() {
        apiRepository.deleteAll()
    }

    @Test
    fun saveTest() {
        // given
        val apiCreate = ApiCreate(
            apiName = "TEST API",
            projectId = 1L,
        )

        // when
        val api = apiService.save(apiCreate)

        // then
        assertThat(api.id).isNotNull()
        assertThat(api.apiName).isEqualTo("TEST API")
        assertThat(api.projectId).isEqualTo(1L)
    }

    @Test
    fun updateTest() {
        // given
        val api = apiService.save(
            ApiCreate(
                apiName = "TEST API",
                projectId = 1L,
            )
        )

        val apiUpdate = ApiUpdate(apiName = "UPDATE API NAME")

        // when
        val updateApi = apiService.update(api.id!!, apiUpdate)

        // then
        assertThat(updateApi.id).isEqualTo(api.id)
        assertThat(updateApi.projectId).isEqualTo(1L)
        assertThat(updateApi.apiName).isEqualTo("UPDATE API NAME")
    }

}