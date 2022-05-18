package com.embassylegacy.newsapp.shared

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.embassylegacy.newsapp.data.NewsArticle
import com.embassylegacy.newsapp.databinding.ItemNewsArticleBinding


class NewsArticleListAdapter : ListAdapter<NewsArticle, NewsArticleViewHolder>(NewsArticleComparator()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsArticleViewHolder {
        val binding =
            ItemNewsArticleBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NewsArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsArticleViewHolder, position: Int) {
      val currentItem = getItem(position)
        if(currentItem !=null){
            holder.bind(currentItem)
        }
    }


}