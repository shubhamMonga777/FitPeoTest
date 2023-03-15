package com.test.fitpeotest.useCase

import com.test.fitpeotest.domain.Album
import com.test.fitpeotest.mapper.DataMapper
import com.test.fitpeotest.network.repo.DataRepository
import com.test.fitpeotest.util.Result
import javax.inject.Inject

class AlbumUseCase @Inject constructor(
    private val dataRepo: DataRepository,
    private val dataMapper: DataMapper
) {
    suspend fun getApiData(): Result<List<Album>> {
        val response = dataRepo.retrieveApiData()
        return response.getOrNull()?.let {
            val ui = dataMapper.mapList(response = it)
            Result.Success(ui)
        } ?: Result.Failure(response.exceptionOrNull())
    }
}