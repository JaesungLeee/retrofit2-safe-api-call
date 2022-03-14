package com.example.retrofithandlestatus.data.datasource.signin

import com.example.retrofithandlestatus.data.model.signin.request.ReqSignInSuccessData
import com.example.retrofithandlestatus.data.model.signin.response.ResSignInSuccessData

interface SignInDataSource {
    suspend fun postSignIn(data: ReqSignInSuccessData): ResSignInSuccessData
}