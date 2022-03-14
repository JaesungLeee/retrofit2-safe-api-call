package com.example.retrofithandlestatus.di

import com.example.retrofithandlestatus.data.api.LoginService
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addNetworkInterceptor(XAccessTokenInterceptor())
            .addInterceptor(Interceptor { chain ->
                chain.proceed(
                    chain.request().newBuilder().build()
                )
            })
            .build()
    }

    single<Retrofit>{
        Retrofit.Builder()
            .client(get())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .baseUrl("Your Base URL")
            .build()
    }

    single<LoginService>{
        get<Retrofit>().create(LoginService::class.java)
    }
}