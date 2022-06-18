package com.example.demodogswelove.framework.android.ui.dogs

import androidx.lifecycle.ViewModel
import com.example.demodogswelove.application.model.DogModel
import com.example.demodogswelove.application.port.input.GetDogsInputPort
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

/**
 * Created by Javier Pulido on 17/junio/2022
 */
class DogsOverviewViewModel(private val getDogsInputPort: GetDogsInputPort) : ViewModel() {

    companion object {
        private const val ERROR_MESSAGE_EMPTY_LIST = "La lista de perros es vacía"
        private const val LOADING_VISIBLE_NO = false
        private const val LOADING_VISIBLE_YES = true
    }

    private val _shoDogsList = MutableSharedFlow<List<DogModel>>()
    val shoDogsList = _shoDogsList.asSharedFlow()

    private val _showDogsServiceError = MutableSharedFlow<String>()
    val showDogsServiceError = _showDogsServiceError.asSharedFlow()

    private val _showLoading = MutableSharedFlow<Boolean>()
    val showLoading = _showLoading.asSharedFlow()

    suspend fun getDogs() {
        _showLoading.emit(LOADING_VISIBLE_YES)
        val getDogsResult = getDogsInputPort.getDogs()
        if (getDogsResult.isNotEmpty()) {
            _shoDogsList.emit(getDogsResult)
        } else {
            _showDogsServiceError.emit(ERROR_MESSAGE_EMPTY_LIST)
        }
        _showLoading.emit(LOADING_VISIBLE_NO)
    }
}