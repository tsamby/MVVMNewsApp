package com.embassylegacy.newsapp.shared

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.embassylegacy.newsapp.R
import com.embassylegacy.newsapp.data.NewsArticle
import com.embassylegacy.newsapp.databinding.ItemNewsArticleBinding

class NewsArticleViewHolder(
    private val binding: ItemNewsArticleBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(article : NewsArticle){
        binding.apply {
            Glide.with(itemView)
                .load(article.thumbnailUrl)
                .error(R.drawable.image_placeholder)
                .into(imageview)

            textViewTitle.text = article.title ?: ""

            imageViewBookmark.setImageResource(
                when{
                    article.isBookmarked -> R.drawable.ic_bookmark_selected
                    else -> R.drawable.ic_bookmark_unselected
                }
            )
        }
    }
}