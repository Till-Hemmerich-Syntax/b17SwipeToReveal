package com.syntax.hemmerich.batch17itemactions.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.syntax.hemmerich.batch17itemactions.data.model.ItemDataClass
import com.syntax.hemmerich.batch17itemactions.databinding.ListItemBinding

class ItemAdapter(var dataSet: List<ItemDataClass>) :RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    class ItemViewHolder(val binding: ListItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val data = dataSet[position]
        holder.binding.tvItem.text = data.title
    }

}