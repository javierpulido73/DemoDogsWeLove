package com.example.demodogswelove.framework.api.retrofit

import com.example.demodogswelove.application.model.DogModel
import retrofit2.Response

/**
 * Created by Javier Pulido on 17/junio/2022
 */
interface ApiHelper {
    suspend fun getDogs(): Response<List<DogModel>>
}