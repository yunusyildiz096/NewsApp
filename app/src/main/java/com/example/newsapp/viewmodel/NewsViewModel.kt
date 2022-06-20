package com.example.newsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.api.NewsRetrofit
import com.example.newsapp.model.Article
import com.example.newsapp.model.NewsResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {
    val newsRetrofit = NewsRetrofit()

    val _response = MutableLiveData<NewsResponse>()
    val getNews : LiveData<NewsResponse>
        get() = _response


    init {
        getDataAll()

    }


    fun getDataAll() = viewModelScope.launch {
            newsRetrofit.getData().let { response ->
                if (response.isSuccessful){
                    _response.postValue(response.body())
                }
            }
    }


}