package com.example.retrofithandlestatus.util

import com.example.retrofithandlestatus.domain.model.ErrorBody
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException

suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher,
    apiCall: suspend () -> T): ResultWrapper<T> {
    return withContext(dispatcher) {
        try {
            ResultWrapper.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            when(throwable) {
                is IOException -> ResultWrapper.NetworkError
                is HttpException -> {
                    val code = throwable.code()
                    val errorBody = throwable.response()?.errorBody()?.string()
                    Timber.d(code.toString())
                    Timber.d(errorBody)
                    val gsonErrorBody = Gson().fromJson(
                        errorBody,
                        ErrorBody::class.java
                    )
                    val message = gsonErrorBody.message
                    ResultWrapper.GenericError(code, message)
                }
                else -> ResultWrapper.GenericError(null, null)
            }
        }
    }
}