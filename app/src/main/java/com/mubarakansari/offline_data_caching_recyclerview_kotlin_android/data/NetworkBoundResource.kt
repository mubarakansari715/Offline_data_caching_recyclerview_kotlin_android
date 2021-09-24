package com.mubarakansari.offline_data_caching_recyclerview_kotlin_android.data

import com.mubarakansari.offline_data_caching_recyclerview_kotlin_android.util.ApiState
import kotlinx.coroutines.flow.*


inline fun <ResultType, RequestType> networkboundResource(
    crossinline query: () -> Flow<ResultType>,
    crossinline fetch: suspend () -> RequestType,
    crossinline saveFetchResult: suspend (RequestType) -> Unit,
    crossinline shouldFetch: (ResultType) -> Boolean = { true }

) = flow {
    val data = query().first()

    val flowData = if (shouldFetch(data)) {
        emit(ApiState.Loading(data))

        try {
            saveFetchResult(fetch())
            query().map { ApiState.Success(it) }
        } catch (throwable: Throwable) {
            query().map { ApiState.Error(throwable, it) }
        }
    } else {
        query().map { ApiState.Success(it) }
    }

    emitAll(flowData)
}