package com.example.retrofithandlestatus.data.mapper.signin

import com.example.retrofithandlestatus.data.model.signin.response.ResSignInSuccessData
import com.example.retrofithandlestatus.domain.model.signin.SignInSuccessData

object SignInMapper {

    fun mapperSignInSuccessData(resSignInSuccessData: ResSignInSuccessData)
            : SignInSuccessData {
        return SignInSuccessData(
            message = resSignInSuccessData.message,
            status = resSignInSuccessData.status,
            token = resSignInSuccessData.token
        )
    }
}