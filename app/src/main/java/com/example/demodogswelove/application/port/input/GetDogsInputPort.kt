package com.example.demodogswelove.application.port.input

import com.example.demodogswelove.application.model.DogModel

/**
 * Created by Javier Pulido on 17/junio/2022
 */
interface GetDogsInputPort {
    suspend fun getDogs(): List<DogModel>
}
