package com.example.technews

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.technews.data.News
import com.example.technews.databinding.NewsTileBinding
import com.squareup.picasso.Picasso

class TechRvAdapter(private val NewsData: News):RecyclerView.Adapter<TechRvAdapter.ViewHolder>() {
    inner class ViewHolder(binding:NewsTileBinding):RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = NewsTileBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        NewsTileBinding.bind(holder.itemView).apply {
            newsTitle.text = NewsData.articles[position].title
            newsDescription.text = NewsData.articles[position].description
            newsSource.text = NewsData.articles[position].source.name
            Picasso.get().load(NewsData.articles[position].urlToImage).into(newsImageView)
        }
    }

    override fun getItemCount() = NewsData.articles.size

}