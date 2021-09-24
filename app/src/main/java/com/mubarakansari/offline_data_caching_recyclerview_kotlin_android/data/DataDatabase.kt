package com.mubarakansari.offline_data_caching_recyclerview_kotlin_android.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mubarakansari.offline_data_caching_recyclerview_kotlin_android.Network.DaoDataInterface

@Database(entities = [DataModelItem::class],version = 1)
abstract class DataDatabase :RoomDatabase() {

    abstract fun daoDataInterface():DaoDataInterface


}