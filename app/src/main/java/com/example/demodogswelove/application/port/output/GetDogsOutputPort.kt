package com.example.demodogswelove.application.port.output

import com.example.demodogswelove.application.model.DogModel

/**
 * Created by Javier Pulido on 17/junio/2022
 */
interface GetDogsOutputPort {
    suspend fun getDogs(): List<DogModel>
}
