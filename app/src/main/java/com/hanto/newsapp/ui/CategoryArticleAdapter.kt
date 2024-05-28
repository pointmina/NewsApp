package com.hanto.newsapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hanto.newsapp.data.Article
import com.hanto.newsapp.data.Category
import com.hanto.newsapp.databinding.ItemCategoryArticleBinding
import com.hanto.newsapp.ui.extensions.load
import com.hanto.newsapp.util.DateFormatText

class CategoryArticleAdapter(
    private val category: Category,
    private val listener: ArticleClickListener
) : RecyclerView.Adapter<CategoryArticleAdapter.CategoryArticleViewHolder>() {

    private val items = mutableListOf<Article>()

    //itemCategoryArticleBinding이라는 클래스로 우리가 뷰에 접근할 수가 있다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryArticleViewHolder {
        return CategoryArticleViewHolder.from(parent, listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CategoryArticleViewHolder, position: Int) {
        holder.bind(category, items[position])
    }

    fun addArticles(articles: List<Article>) {
        val positionStart = items.size
        items.addAll(articles)
        notifyItemRangeInserted(positionStart, articles.size)
//        notifyDataSetChanged()
    }

    class CategoryArticleViewHolder(
        private val binding: ItemCategoryArticleBinding,
        private val listener: ArticleClickListener
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(category: Category, article: Article) {
            itemView.setOnClickListener {
                listener.onArticleClick(category, article)
            }
            with(binding) {
                ivArticleImg.load(article.urlToImage)
                tvArticleTitle.text = article.title
                tvArticleDescription.text = article.description
                tvArticlePublishDate.text = article.publishedAt?.let(DateFormatText::convert)
            }
        }

        companion object {
            //뷰홀더를 생성하는 코드를 함수 본문으로 이동
            //뷰홀더의 생성 방식이 바뀌게 되면서 뷰홀더 내부의 코드만 수정을 하면 되는 점이 코드를 관리하기 쉬워진다.
            fun from(parent: ViewGroup, listener: ArticleClickListener): CategoryArticleViewHolder {
                val binding = ItemCategoryArticleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return CategoryArticleViewHolder(binding, listener)
            }
        }

    }
}

