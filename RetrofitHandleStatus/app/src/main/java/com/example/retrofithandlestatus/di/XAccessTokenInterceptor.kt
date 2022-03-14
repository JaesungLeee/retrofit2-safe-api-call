package com.example.retrofithandlestatus.di

import com.example.retrofithandlestatus.di.EarthGardenerApplication.Companion.X_AUTH_TOKEN
import com.example.retrofithandlestatus.di.EarthGardenerApplication.Companion.sSharedPreferences
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class XAccessTokenInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val builder: Request.Builder = chain.request().newBuilder()
        val jwtToken: String? = sSharedPreferences.getString(X_AUTH_TOKEN, null)
        if(jwtToken != null){
            builder.addHeader("X-AUTH-TOKEN", jwtToken)
        }
        return chain.proceed(builder.build())
    }
}