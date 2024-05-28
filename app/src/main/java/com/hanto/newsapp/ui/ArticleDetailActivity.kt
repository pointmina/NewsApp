package com.hanto.newsapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.navArgs
import com.hanto.newsapp.databinding.ActivityArticleDetailBinding
import com.hanto.newsapp.ui.extensions.load
import com.hanto.newsapp.util.DateFormatText

class ArticleDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityArticleDetailBinding

    //nav args라는 함수한테 이 변수를 초기화 하는 것을 위임한다.
    private val args: ArticleDetailActivityArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticleDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //graph에 argument 추가해서 deteail activity에 전달 받은 데이터를
        //읽어올 수 있는 상태가 되었다.
        setLayout()
    }

    private fun setLayout() {
        with(binding) {
            toolbarArticleDetail.setNavigationOnClickListener {
                finish()
            }
            tvArticleDetailCategoty.text = args.category.label.replaceFirstChar { it.uppercase() }
            ivArticleDetailImg.load(args.article.urlToImage)
            tvArticleDatailTitle.text = args.article.title
            tvArticleDetailDescription.text = args.article.description
            tvArticleDetailDate.text = args.article.publishedAt?.let(DateFormatText::convert)
        }
    }


}