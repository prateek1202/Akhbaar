package com.example.technews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.technews.data.DataResponse
import com.example.technews.data.repository.NewsRetriever
import com.example.technews.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
//        loadNews(binding.recyclerView)
        binding.recyclerView.adapter = TechRvAdapter(DataResponse().response)
    }
    private fun loadNews(recyclerView:RecyclerView){
        val fragmentJob = Job()
        val coroutineScope = CoroutineScope(fragmentJob+ Dispatchers.Main)
        coroutineScope.launch {
            val newsData = NewsRetriever().getNews()
            recyclerView.adapter = TechRvAdapter(newsData)
        }
    }
}