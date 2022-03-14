package com.example.retrofithandlestatus.domain.repository.signin

import com.example.retrofithandlestatus.data.model.signin.request.ReqSignInSuccessData
import com.example.retrofithandlestatus.domain.model.signin.SignInSuccessData

interface SignInRepository {
    suspend fun postSignInResult(data: ReqSignInSuccessData): SignInSuccessData
}