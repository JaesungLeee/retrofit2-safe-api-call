package com.example.retrofithandlestatus.data.api

import com.example.retrofithandlestatus.data.model.signin.request.ReqSignInSuccessData
import com.example.retrofithandlestatus.data.model.signin.response.ResSignInSuccessData
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    // Post SignIn
    @POST("Your API Endpoint URL")
    suspend fun postSignIn(
        @Body data: ReqSignInSuccessData
    ): ResSignInSuccessData
}