# retrofit2-safe-api-call
Handle various HTTP status code by safe api call with Result sealed class

## Library
* Retrofit2
* OkHttp3
* Gson
* Coroutine
* DI : Koin
* ViewModel
* LiveData
* Timber

## Code
### ResultWrapper
``` kotlin
package com.example.retrofithandlestatus.util

sealed class ResultWrapper<out T> {
    data class Success<out T>(val data: T) : ResultWrapper<T>()
    data class GenericError(val code: Int?, val message: String?) : ResultWrapper<Nothing>()
    object NetworkError : ResultWrapper<Nothing>()
}
```

### SafeApiCall
``` kotlin
suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher,
    apiCall: suspend () -> T
): ResultWrapper<T> {
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
```
* Use `string()` method instead of `toString()`
``` kotlin
val errorBody = throwable.response()?.errorBody()?.string()
```
