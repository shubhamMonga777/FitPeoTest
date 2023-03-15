package com.test.fitpeotest.network.repo

import com.test.fitpeotest.network.api.ApiService
import com.test.fitpeotest.network.model.AlbumModel
import javax.inject.Inject

class DataRepoImpl @Inject constructor(
    private val apiService: ApiService
) : DataRepository {

    override suspend fun retrieveApiData(): Result<List<AlbumModel>> {
        return try {
            val data = apiService.getAlbumList()
            Result.success(data)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}