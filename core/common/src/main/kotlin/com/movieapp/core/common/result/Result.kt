package com.movieapp.core.common.result

/**
 * A generic class that holds a loading signal, successful data or an error exception
 */
sealed class ApiResult<out T> {
    data class Loading(val isLoading: Boolean = true) : ApiResult<Nothing>()
    data class Success<out T>(val data: T) : ApiResult<T>()
    data class Error(val exception: Throwable) : ApiResult<Nothing>()
}

/**
 * Extension function to handle ApiResult states
 */
inline fun <T> ApiResult<T>.onSuccess(action: (T) -> Unit): ApiResult<T> {
    if (this is ApiResult.Success) {
        action(data)
    }
    return this
}

/**
 * Extension function to handle error states
 */
inline fun <T> ApiResult<T>.onError(action: (Throwable) -> Unit): ApiResult<T> {
    if (this is ApiResult.Error) {
        action(exception)
    }
    return this
}

/**
 * Extension function to handle loading states
 */
inline fun <T> ApiResult<T>.onLoading(action: (Boolean) -> Unit): ApiResult<T> {
    if (this is ApiResult.Loading) {
        action(isLoading)
    }
    return this
}

/**
 * Extension function to get data or null
 */
fun <T> ApiResult<T>.getDataOrNull(): T? {
    return if (this is ApiResult.Success) data else null
}