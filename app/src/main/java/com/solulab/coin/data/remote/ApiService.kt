package com.solulab.coin.data.remote

import com.solulab.coin.data.remote.dto.ResponseDto
import retrofit2.http.GET


interface ApiService {

    @GET("/coinlist")
    suspend fun getDataFromApiService(): ResponseDto

}