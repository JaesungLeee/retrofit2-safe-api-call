package com.example.retrofithandlestatus.domain.model.signin

data class SignInSuccessData(
    val message: String,
    val status: Int,
    val token: String
)
