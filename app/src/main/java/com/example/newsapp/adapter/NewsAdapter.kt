package com.example.newsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.databinding.NewsItemBinding
import com.example.newsapp.fragments.NewsFragmentDirections
import com.example.newsapp.model.Article
import com.example.newsapp.model.NewsResponse
import com.google.android.material.bottomsheet.BottomSheetDialog

class NewsAdapter(val newsList: NewsResponse) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(val binding : NewsItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val recyclerBinding = NewsItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NewsViewHolder(recyclerBinding)
    }
    private var onItemClickListener: ((Article) -> Unit)? = null

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.binding.newsTitle.text = newsList.articles.get(position).title
        holder.binding.newsDescription.text = newsList.articles.get(position).description
        holder.binding.newsPublishedAt.text = newsList.articles.get(position).publishedAt
        Glide.with(holder.itemView.context).load(newsList.articles.get(position).urlToImage).into(holder.binding.newsImage)
        holder.itemView.setOnClickListener {
           val nav = NewsFragmentDirections.actionNewsFragmentToNewsWebFragment(newsList.articles.get(position).url)
           Navigation.findNavController(it).navigate(nav)
        }
        holder.itemView.setOnLongClickListener(View.OnLongClickListener {

            val bottomSheet = BottomSheetDialog(holder.binding.root.context)
            bottomSheet.setContentView(R.layout.bottom_sheet_description)
            val descriptionBottom = bottomSheet.findViewById<TextView>(R.id.bottom_description)

            descriptionBottom!!.text = newsList.articles.get(position).description
            bottomSheet.show()
                return@OnLongClickListener true
        })






    }

    override fun getItemCount(): Int {
        return newsList.articles.size
    }

}