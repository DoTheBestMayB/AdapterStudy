package com.dothebestmayb.adapter.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dothebestmayb.adapter.databinding.ItemSimpleBinding
import com.dothebestmayb.adapter.model.SimpleData

class MyListAdapter : ListAdapter<SimpleData, MyListAdapter.MyViewHolder>(diff){

    val TAG = MyListAdapter::class.java.simpleName
    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)

        Log.i(TAG, "onDetachedFromRecyclerView is called")
    }

    class MyViewHolder(private val binding: ItemSimpleBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SimpleData) {
            binding.tv.text = item.num.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ItemSimpleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        val diff = object: DiffUtil.ItemCallback<SimpleData>() {
            override fun areItemsTheSame(oldItem: SimpleData, newItem: SimpleData): Boolean {
                return oldItem.num == newItem.num
            }

            override fun areContentsTheSame(oldItem: SimpleData, newItem: SimpleData): Boolean {
                return oldItem == newItem
            }

        }
    }


}