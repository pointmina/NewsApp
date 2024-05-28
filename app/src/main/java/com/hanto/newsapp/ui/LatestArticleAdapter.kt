import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hanto.newsapp.data.Article
import com.hanto.newsapp.data.Category
import com.hanto.newsapp.databinding.ItemLatestArticleBinding
import com.hanto.newsapp.ui.ArticleClickListener
import com.hanto.newsapp.ui.extensions.load
import com.hanto.newsapp.util.DateFormatText

class LatestArticleAdapter(
    private val listener: ArticleClickListener
) : RecyclerView.Adapter<LatestArticleAdapter.LatestArticleViewHolder>() {

    private val items = mutableListOf<Article>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatestArticleViewHolder {
        return LatestArticleViewHolder.from(parent, listener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: LatestArticleViewHolder, position: Int) {
        holder.bind(items[position])
    }

    //데이터 추가

    fun addArticles(articles: List<Article>) {
        val positionStart = items.size
        items.addAll(articles)
        notifyItemRangeInserted(positionStart, articles.size)
    }

    class LatestArticleViewHolder(
        private val binding: ItemLatestArticleBinding,
        private val listener: ArticleClickListener
    ) :
        RecyclerView.ViewHolder(binding.root) {
        //뷰 속성에 데이터를 할당한다.
        fun bind(article: Article) {
            itemView.setOnClickListener {
                listener.onArticleClick(Category.Default, article)
            }
            with(binding) {
                ivLatestArticleImg.load(article.urlToImage)
                tvLatestArticleTitle.text = article.title
                tvLatestArticlePublishDate.text = article.publishedAt?.let(DateFormatText::convert)
            }
        }

        companion object {
            fun from(parent: ViewGroup, listener: ArticleClickListener): LatestArticleViewHolder {
                val binding = ItemLatestArticleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                return LatestArticleViewHolder(binding, listener)
            }
        }
    }
}