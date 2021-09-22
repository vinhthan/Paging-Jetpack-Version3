package com.example.pagingjetpackversion3

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pagingjetpackversion3.model.Results

class UserAdapter: PagingDataAdapter<Results, UserAdapter.MyViewHolder>(DiffUtilCallBack()) {

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position)!!)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return MyViewHolder(view)
    }

    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val imgAvatar: ImageView = view.findViewById(R.id.img_avatar)
        private val tvName: TextView = view.findViewById(R.id.tv_name)

        fun bind(data: Results) {
            tvName.text = data.name
            Glide.with(imgAvatar).load(data.image).centerCrop().into(imgAvatar)
        }
    }

    class DiffUtilCallBack: DiffUtil.ItemCallback<Results>() {
        override fun areItemsTheSame(oldItem: Results, newItem: Results): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Results, newItem: Results): Boolean {
            return oldItem.name == newItem.name
        }

    }
}