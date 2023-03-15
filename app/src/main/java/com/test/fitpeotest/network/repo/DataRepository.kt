package com.test.fitpeotest.network.repo

import com.test.fitpeotest.network.model.AlbumModel

interface DataRepository {

    suspend fun retrieveApiData() :Result<List<AlbumModel>>

}