package org.example.hexagonalarchitecture.api.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ApiTest {

    @Test
    fun saveTest() {
        // given
        val apiCreate = ApiCreate(
            apiName = "TEST API",
            projectId = 1L,
        )

        // when
        val api = Api.of(apiCreate)

        // then
        assertThat(api.id).isNull()
        assertThat(api.apiName).isEqualTo("TEST API")
        assertThat(api.projectId).isEqualTo(1L)
    }

    @Test
    fun updateTest() {
        // given
        val api = Api(
            apiName = "TEST API",
            projectId = 1L,
            id = 1L,
        )

        val apiUpdate = ApiUpdate(apiName = "UPDATE API NAME")

        // when
        val updateApi = api.update(apiUpdate)

        // then
        assertThat(updateApi.id).isEqualTo(1L)
        assertThat(updateApi.projectId).isEqualTo(1L)
        assertThat(updateApi.apiName).isEqualTo("UPDATE API NAME")
    }
}