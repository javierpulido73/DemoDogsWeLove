package com.example.demodogswelove.framework.api.retrofit

import com.example.demodogswelove.application.model.DogModel
import com.example.demodogswelove.interfaceAdapter.gateway.DogsGateway

/**
 * Created by Javier Pulido on 17/junio/2022
 */
class ApiHelperImpl(
    private val apiService: ApiService
) : DogsGateway {

    override suspend fun getDogs(): List<DogModel> = apiService.getDogs().body() ?: emptyList()
}