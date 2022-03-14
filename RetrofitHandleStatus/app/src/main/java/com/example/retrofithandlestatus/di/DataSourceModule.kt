package com.example.retrofithandlestatus.di

import com.example.retrofithandlestatus.data.datasource.signin.SignInDataSource
import com.example.retrofithandlestatus.data.datasource.signin.SignInDataSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single<SignInDataSource>{ SignInDataSourceImpl(get()) }

}