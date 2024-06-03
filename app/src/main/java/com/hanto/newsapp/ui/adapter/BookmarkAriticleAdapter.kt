package com.hanto.newsapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hanto.newsapp.data.Article
import com.hanto.newsapp.databinding.ItemBookmarkArticleBinding
import com.hanto.newsapp.ui.extensions.load
import com.hanto.newsapp.util.DateFormatText

class BookmarkAriticleAdapter() : RecyclerView.Adapter<BookmarkAriticleAdapter.BookmarkArticleViewHolder>() {

    private val items = mutableListOf<Article>()
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): BookmarkAriticleAdapter.BookmarkArticleViewHolder {
        return BookmarkArticleViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: BookmarkAriticleAdapter.BookmarkArticleViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class BookmarkArticleViewHolder(private val binding : ItemBookmarkArticleBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            with(binding) {
                ivBookmarkArticleImg.load(article.urlToImage)
                tvBookmarkTitle.text= article.title
                tvBookmarkArticlePublishDate.text = article.publishedAt?.let(DateFormatText::convert)
            }
        }


        companion object{
            fun from(parent: ViewGroup): BookmarkArticleViewHolder {
                return BookmarkArticleViewHolder(
                    ItemBookmarkArticleBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )

            }
        }
    }

}