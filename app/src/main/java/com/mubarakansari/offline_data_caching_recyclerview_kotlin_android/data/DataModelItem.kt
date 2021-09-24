package com.mubarakansari.offline_data_caching_recyclerview_kotlin_android.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "datatable")
data class DataModelItem(
    @PrimaryKey val id: Int,
    val address: String,
    val description: String,
    val logo: String,
    val name: String,
    val phone_number: String,
    val review: String,
    val type: String,
    val uid: String
)