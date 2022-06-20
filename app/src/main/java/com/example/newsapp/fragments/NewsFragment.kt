package com.example.newsapp.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.R
import com.example.newsapp.adapter.NewsAdapter
import com.example.newsapp.databinding.NewsFragmentBinding
import com.example.newsapp.viewmodel.NewsViewModel

class NewsFragment : Fragment(R.layout.news_fragment) {

    private var fragmentBinding : NewsFragmentBinding? = null
    val viewModel : NewsViewModel by viewModels()
    var adapter : NewsAdapter? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = NewsFragmentBinding.bind(view)
        fragmentBinding = binding

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())




        viewModel.getNews.observe(viewLifecycleOwner, Observer {
            adapter = NewsAdapter(it)
            binding.recyclerView.adapter = adapter
        })

    }
}