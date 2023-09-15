package com.example.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.main.databinding.ItemBookBinding

class MainAdapter : RecyclerView.Adapter<MainAdapter.ViewHolder>(){
    lateinit var items: ArrayList<Book>

    fun build(i: ArrayList<Book>) : MainAdapter{
        items = i
        return this
    }

    class ViewHolder(val binding: ItemBookBinding, val context: Context) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: Book){
            with(binding){
                titleTv.text = item.title
                if(item.heart.toString() == "true"){
                    heartIv.setImageResource(R.drawable.heart)
                }
                else{
                    heartIv.setImageResource(R.drawable.blank_heart)
                }
                keywordRv.apply {
                    adapter = KeywordAdapter().build(item.keywords)
                    layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder = ViewHolder(
        ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false), parent.context)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }


}