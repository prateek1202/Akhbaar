package com.example.technews.data.repository

import com.example.technews.data.News
import retrofit2.http.GET
import retrofit2.http.Headers

interface NewsService {
//    @Headers("apiKey:442018783da441f7b1db92edad71c4a6")
//    @GET("/top-headlines")
    @GET("/v2/top-headlines?apiKey=442018783da441f7b1db92edad71c4a6&language=en&source=cnn")
    suspend fun getTechNews(): News

}