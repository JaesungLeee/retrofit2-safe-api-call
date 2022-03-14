package com.example.retrofithandlestatus.data.repository.signin

import com.example.retrofithandlestatus.data.datasource.signin.SignInDataSource
import com.example.retrofithandlestatus.data.mapper.signin.SignInMapper
import com.example.retrofithandlestatus.data.model.signin.request.ReqSignInSuccessData
import com.example.retrofithandlestatus.domain.model.signin.SignInSuccessData
import com.example.retrofithandlestatus.domain.repository.signin.SignInRepository

class SignInRepositoryImpl(private val signInDataSource: SignInDataSource) : SignInRepository {
    override suspend fun postSignInResult(data: ReqSignInSuccessData): SignInSuccessData {
        return SignInMapper.mapperSignInSuccessData(signInDataSource.postSignIn(data))
    }
}