package com.example.retrofithandlestatus.data.datasource.signin

import com.example.retrofithandlestatus.data.api.LoginService
import com.example.retrofithandlestatus.data.model.signin.request.ReqSignInSuccessData
import com.example.retrofithandlestatus.data.model.signin.response.ResSignInSuccessData

class SignInDataSourceImpl(private val loginService: LoginService)
    : SignInDataSource{
    override suspend fun postSignIn(data: ReqSignInSuccessData): ResSignInSuccessData {
        return loginService.postSignIn(data)
    }

}