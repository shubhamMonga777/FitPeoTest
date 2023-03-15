package com.test.fitpeotest.network.api

import com.test.fitpeotest.network.model.AlbumModel
import com.test.fitpeotest.network.util.Constants
import retrofit2.http.GET

interface ApiService {

    @GET(Constants.API_ENDPOINT)
    suspend fun getAlbumList(): List<AlbumModel>

}