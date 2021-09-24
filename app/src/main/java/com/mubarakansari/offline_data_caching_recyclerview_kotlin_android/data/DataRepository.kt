package com.mubarakansari.offline_data_caching_recyclerview_kotlin_android.data

import androidx.room.withTransaction
import com.mubarakansari.offline_data_caching_recyclerview_kotlin_android.Network.ApiService
import kotlinx.coroutines.delay
import javax.inject.Inject

//this for room database
class DataRepository @Inject constructor(
    private val apiService: ApiService,
    private val db:DataDatabase
) {
    private val daoDataInterface = db.daoDataInterface()

    fun getData() = networkboundResource(
        query = {
            daoDataInterface.getAllData()
        },
        fetch = {
            delay(2000)
            apiService.getAllData()
        },
        saveFetchResult = {
            db.withTransaction {
                daoDataInterface.deleteData()
                daoDataInterface.insertData(it)
            }
        }
    )

}