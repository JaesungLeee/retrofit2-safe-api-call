package com.example.retrofithandlestatus.di

import com.example.retrofithandlestatus.data.repository.signin.SignInRepositoryImpl
import com.example.retrofithandlestatus.domain.repository.signin.SignInRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<SignInRepository> { SignInRepositoryImpl(get()) }
}