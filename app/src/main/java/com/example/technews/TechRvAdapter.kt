package com.example.technews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.technews.data.News
import com.example.technews.databinding.NewsTileBinding

class TechRvAdapter(private val NewsData: News):RecyclerView.Adapter<TechRvAdapter.ViewHolder>() {
    inner class ViewHolder(val binding:NewsTileBinding):RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = NewsTileBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(NewsData.articles[position]){
                binding.newsTitle.text = this.title
                binding.newsDescription.text = this.description
                binding.newsSource.text = this.source.name
            }
        }
    }

    override fun getItemCount(): Int {
        return NewsData.articles.size
    }

}