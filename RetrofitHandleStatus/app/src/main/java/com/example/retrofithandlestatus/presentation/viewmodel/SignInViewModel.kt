package com.example.retrofithandlestatus.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.retrofithandlestatus.data.model.signin.request.ReqSignInSuccessData
import com.example.retrofithandlestatus.domain.model.signin.SignInSuccessData
import com.example.retrofithandlestatus.domain.usecase.SignInUseCase
import com.example.retrofithandlestatus.util.ResultWrapper
import com.example.retrofithandlestatus.util.safeApiCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

class SignInViewModel(
    private val signInUseCase: SignInUseCase
) : ViewModel() {

    var signInStatus = MutableLiveData<Int>()
    private var _signInResponseData = MutableLiveData<SignInSuccessData?>()
    val signInResponseData: LiveData<SignInSuccessData?>
        get() = _signInResponseData

    fun postSignIn(data: ReqSignInSuccessData) = viewModelScope.launch {
        when (val responseData =
            safeApiCall(Dispatchers.IO) { signInUseCase(data) }) {
            is ResultWrapper.Success -> {
                Timber.d("postSignIn : Success")
                _signInResponseData.value = responseData.data
                signInStatus.value = 200
            }
            is ResultWrapper.NetworkError -> {
                Timber.d("postSignIn : Network Err")
            }
            is ResultWrapper.GenericError -> {
                Timber.d("postSignIn : Generic Err")
                signInStatus.value = responseData.code ?: 0
            }
        }
    }
}