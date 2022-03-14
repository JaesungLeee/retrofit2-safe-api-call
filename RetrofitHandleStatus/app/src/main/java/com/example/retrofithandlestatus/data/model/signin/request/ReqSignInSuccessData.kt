package com.example.retrofithandlestatus.data.model.signin.request

import com.google.gson.annotations.SerializedName

data class ReqSignInSuccessData(
    @SerializedName("email")
    val email: String,

    @SerializedName("pw")
    val pw: String
)
