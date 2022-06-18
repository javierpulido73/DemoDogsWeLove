package com.example.demodogswelove.framework.koin.module

import com.example.demodogswelove.application.port.input.GetDogsInputPort
import com.example.demodogswelove.application.useCase.GetDogsUseCase
import com.example.demodogswelove.framework.android.ui.dogs.DogsOverviewActivity
import com.example.demodogswelove.framework.android.ui.dogs.DogsOverviewViewModel
import com.example.demodogswelove.framework.api.retrofit.ApiHelperImpl
import com.example.demodogswelove.interfaceAdapter.gateway.DogsGateway
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Javier Pulido on 17/junio/2022
 */
val mainModule = module {
    scope<DogsOverviewActivity> {
        factory<DogsGateway> { ApiHelperImpl(get()) }
        factory<GetDogsInputPort> { parameters -> GetDogsUseCase(parameters.get()) }
        viewModel { parameters -> DogsOverviewViewModel(parameters.get()) }
    }
}
