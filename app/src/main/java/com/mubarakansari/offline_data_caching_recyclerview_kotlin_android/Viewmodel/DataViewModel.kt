package com.mubarakansari.offline_data_caching_recyclerview_kotlin_android.Viewmodel

import androidx.lifecycle.*
import com.mubarakansari.offline_data_caching_recyclerview_kotlin_android.Network.ApiService
import com.mubarakansari.offline_data_caching_recyclerview_kotlin_android.data.DataModel
import com.mubarakansari.offline_data_caching_recyclerview_kotlin_android.data.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(repository: DataRepository) : ViewModel() {

    val data= repository.getData().asLiveData()




//    private val dataLiveData = MutableLiveData<DataModel>()
//    val data: LiveData<DataModel> = dataLiveData
//
//    init {
//        viewModelScope.launch {
//            val getData = apiService.getAllData()
//            dataLiveData.value = getData
//
//        }
//    }
}