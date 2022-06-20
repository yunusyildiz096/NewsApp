package com.example.newsapp.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.newsapp.R
import com.example.newsapp.databinding.NewsWebFragmentBinding

class NewsWebFragment : Fragment(R.layout.news_web_fragment) {

    private var fragmentBinding : NewsWebFragmentBinding? = null
    val args : NewsWebFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = NewsWebFragmentBinding.bind(view)
        fragmentBinding = binding

        val article = args.article
        binding.webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article)
        }
    }
}