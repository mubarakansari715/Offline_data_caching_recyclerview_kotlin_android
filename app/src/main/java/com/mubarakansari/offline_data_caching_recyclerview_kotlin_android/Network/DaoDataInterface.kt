package com.mubarakansari.offline_data_caching_recyclerview_kotlin_android.Network

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mubarakansari.offline_data_caching_recyclerview_kotlin_android.data.DataModelItem
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoDataInterface {
    //suspend fun insertData(datatable: List<DataModel>)

    @Query("select * from datatable")
    fun getAllData(): Flow<List<DataModelItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(datatable: List<DataModelItem>)

    @Query("delete from datatable")
    suspend fun deleteData()
}