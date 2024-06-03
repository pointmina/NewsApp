package com.hanto.newsapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hanto.newsapp.data.BookmarkArticleList
import com.hanto.newsapp.databinding.ItemBookmarkBinding

class BookmarkAdapter() : RecyclerView.Adapter<BookmarkAdapter.BookmarkViewHolder>() {

    private val items = mutableListOf<BookmarkArticleList> ()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkViewHolder {
        return BookmarkViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: BookmarkAdapter.BookmarkViewHolder, postion: Int) {
        holder.bind(items[postion])
    }

    class BookmarkViewHolder(private val binding: ItemBookmarkBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : BookmarkArticleList) {
            binding.tvBookmarkCategoryTitle.text = item.category.label
            binding.rvBookmarkCategoryArticleList.adapter = BookmarkAriticleAdapter()
        }
        companion object {
            fun from(parent: ViewGroup): BookmarkViewHolder {
                return BookmarkViewHolder(
                    ItemBookmarkBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )

            }
        }
    }

}