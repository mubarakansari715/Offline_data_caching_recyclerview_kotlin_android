package com.mubarakansari.offline_data_caching_recyclerview_kotlin_android.Network

import com.mubarakansari.offline_data_caching_recyclerview_kotlin_android.data.DataModel
import retrofit2.http.GET

interface ApiService {
    companion object {
        const val BASE_URL = "https://random-data-api.com/api/"
    }

    @GET("restaurant/random_restaurant?size=100")
    suspend fun getAllData(): DataModel
}