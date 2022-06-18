package com.example.demodogswelove.framework.api.retrofit

import com.example.demodogswelove.application.model.DogModel
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by Javier Pulido on 17/junio/2022
 */
interface ApiService {
    @GET("945366962796773376")
    suspend fun getDogs(): Response<List<DogModel>>
}