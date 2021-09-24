package com.mubarakansari.offline_data_caching_recyclerview_kotlin_android.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mubarakansari.offline_data_caching_recyclerview_kotlin_android.R
import com.mubarakansari.offline_data_caching_recyclerview_kotlin_android.data.DataModelItem
import com.mubarakansari.offline_data_caching_recyclerview_kotlin_android.databinding.ItemViewBinding


class DataAdapter() :
    ListAdapter<DataModelItem, DataAdapter.DataViewModel>(Diff) {

    class DataViewModel(private val binding: ItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(modelItem: DataModelItem) {
            binding.apply {
//                Picasso.get()
//                    .load(modelItem.logo)
//                    .error(R.drawable.ic_launcher_background)
//                    .centerCrop().fit()
//                    .into(imgView)
                Glide.with(itemView)
                    .load(modelItem.logo)
                    .fitCenter()
                    .error(R.drawable.ic_launcher_background)
                    .into(imgView)

                tvTitle.text = modelItem.name
                tvType.text = modelItem.type
                tvAddress.text = modelItem.address
            }
        }
    }

    object Diff : DiffUtil.ItemCallback<DataModelItem>() {
        override fun areItemsTheSame(oldItem: DataModelItem, newItem: DataModelItem): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: DataModelItem, newItem: DataModelItem): Boolean {
            return oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: DataViewModel, position: Int) {
        val model = getItem(position)
        if (model != null) {
            holder.bind(model)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewModel {
        return (DataViewModel(
            ItemViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ))
    }


}

