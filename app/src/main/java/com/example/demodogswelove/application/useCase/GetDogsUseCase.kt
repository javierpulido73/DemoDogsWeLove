package com.example.demodogswelove.application.useCase

import com.example.demodogswelove.application.model.DogModel
import com.example.demodogswelove.application.port.input.GetDogsInputPort
import com.example.demodogswelove.application.port.output.GetDogsOutputPort

/**
 * Created by Javier Pulido on 17/junio/2022
 */
class GetDogsUseCase(private val getDogsOutputPort: GetDogsOutputPort) : GetDogsInputPort {
    override suspend fun getDogs(): List<DogModel> = getDogsOutputPort.getDogs()
}