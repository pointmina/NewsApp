package com.hanto.newsapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hanto.newsapp.databinding.ItemCategoryArticleBinding

class CategoryArticleAdapter(private val items: List<Article>) :
    RecyclerView.Adapter<CategoryArticleAdapter.CategoryArticleViewHolder>() {

    //itemCategoryArticleBinding이라는 클래스로 우리가 뷰에 접근할 수가 있다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryArticleViewHolder {
        return CategoryArticleViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CategoryArticleViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class CategoryArticleViewHolder(private val binding: ItemCategoryArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.tvArticleTitle.text = article.title

        }

        companion object {
            fun from(parent: ViewGroup): CategoryArticleAdapter.CategoryArticleViewHolder {
                val binding = ItemCategoryArticleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return CategoryArticleViewHolder(binding)
            }
        }
    }
}

