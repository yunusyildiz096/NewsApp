package com.example.newsapp.api

import com.example.newsapp.model.Article
import com.example.newsapp.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET

interface NewsAPI {
   // https://newsapi.org/v2/top-headlines?country=tr&category=business&apiKey=f06d61a89295441ab37b44d6b1fcea20
    @GET("v2/top-headlines?country=us&category=technology&apiKey=f06d61a89295441ab37b44d6b1fcea20")
    suspend fun getNews() : Response<NewsResponse>

}