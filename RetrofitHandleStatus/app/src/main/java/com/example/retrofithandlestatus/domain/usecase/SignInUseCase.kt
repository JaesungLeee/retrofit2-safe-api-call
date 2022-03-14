package com.example.retrofithandlestatus.domain.usecase

import com.example.retrofithandlestatus.data.model.signin.request.ReqSignInSuccessData
import com.example.retrofithandlestatus.domain.model.signin.SignInSuccessData
import com.example.retrofithandlestatus.domain.repository.signin.SignInRepository

class SignInUseCase(private val signInRepository: SignInRepository) {

    suspend operator fun invoke(data: ReqSignInSuccessData) : SignInSuccessData {
        return signInRepository.postSignInResult(data)
    }
}