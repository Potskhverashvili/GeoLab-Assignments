package com.example.network.data

import com.example.network.data.model.MarioData
import retrofit2.Response
import retrofit2.http.GET

interface MarioApi {

    @GET("amiibo/?name=mario")
    suspend fun getMarioData(): Response<MarioData>

}