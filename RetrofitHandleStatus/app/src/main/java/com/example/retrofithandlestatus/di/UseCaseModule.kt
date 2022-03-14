package com.example.retrofithandlestatus.di

import com.example.retrofithandlestatus.domain.usecase.SignInUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { SignInUseCase(get()) }
}