package com.example.newsapp.api

import com.example.newsapp.model.Article
import com.example.newsapp.model.NewsResponse
import com.example.newsapp.util.Constants
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsRetrofit {

    private  val api = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(Constants.BASE_URL)
        .build()
        .create(NewsAPI::class.java)

    suspend fun getData() : Response<NewsResponse>{
        return api.getNews()
    }
}