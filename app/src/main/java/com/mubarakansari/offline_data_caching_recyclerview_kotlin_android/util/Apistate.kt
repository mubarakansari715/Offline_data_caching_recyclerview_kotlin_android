package com.mubarakansari.offline_data_caching_recyclerview_kotlin_android.util

sealed class ApiState<T>(
    val data: T? = null,
    val error: Throwable? = null,
) {
    class Success<T>(data: T) : ApiState<T>(data)
    class Loading<T>(data: T? = null) : ApiState<T>(data)
    class Error<T>(throwable: Throwable, data: T? = null) : ApiState<T>(data)
}