package com.example.technews.data.repository

import com.example.technews.data.News
import com.example.technews.data.repository.NewsService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsRetriever {
    private val service: NewsService
    private val URL = "https://newsapi.org"

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(NewsService::class.java)
    }
    suspend fun getNews(): News {
        return service.getTechNews()
    }

}