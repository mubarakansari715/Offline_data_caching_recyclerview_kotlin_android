package com.mubarakansari.offline_data_caching_recyclerview_kotlin_android

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mubarakansari.offline_data_caching_recyclerview_kotlin_android.Viewmodel.DataViewModel
import com.mubarakansari.offline_data_caching_recyclerview_kotlin_android.adapter.DataAdapter
import com.mubarakansari.offline_data_caching_recyclerview_kotlin_android.databinding.ActivityMainBinding
import com.mubarakansari.offline_data_caching_recyclerview_kotlin_android.util.ApiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: DataViewModel by viewModels()
    private lateinit var networkConnectivity: NetworkConnectivity
    private val dataAdapter = DataAdapter()
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        networkConnectivity = NetworkConnectivity(application)
        networkConnectivity.observe(this, Observer {
            when (it) {
                true -> {
                    Toast.makeText(this, "Online", Toast.LENGTH_SHORT).show()
                }
                false -> {
                    Toast.makeText(this, "Offline", Toast.LENGTH_SHORT).show()
                }
            }
        })

        binding.apply {

            recyclerView.apply {
                adapter = dataAdapter
                layoutManager = LinearLayoutManager(this@MainActivity)
            }

            viewModel.data.observe(this@MainActivity, Observer { result ->
                recyclerView.startLayoutAnimation() //animation
                dataAdapter.submitList(result.data)

                progressCircular.isVisible =
                    result is ApiState.Loading && result.data.isNullOrEmpty()
                tv.isVisible = result is ApiState.Error && result.data.isNullOrEmpty()
                tv.text = result.error?.localizedMessage

            })
        }
    }
}

