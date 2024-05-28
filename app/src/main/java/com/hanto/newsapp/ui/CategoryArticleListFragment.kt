package com.hanto.newsapp.ui

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.hanto.newsapp.data.Article
import com.hanto.newsapp.data.Category
import com.hanto.newsapp.data.NewsService
import com.hanto.newsapp.databinding.FragmentCategoryArticleListBinding
import com.hanto.newsapp.util.Constants
import com.hanto.newsapp.util.Constants.KEY_CATEGORY
import kotlinx.coroutines.launch
import java.util.Locale

class CategoryArticleListFragment : Fragment(), ArticleClickListener {

//    객체를 생성하는 함수를 분리해서 사용

    private var _binding: FragmentCategoryArticleListBinding? = null
    private val binding get() = _binding!!
    private lateinit var category: Category

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setCategory()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoryArticleListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setLayout()
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setCategory() {
        category = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getSerializable(KEY_CATEGORY, Category::class.java) as? Category
        } else {
            arguments?.getSerializable(KEY_CATEGORY) as? Category
        } ?: Category.Business
    }


    //객체 생성과 관련된 코드를 이 함수에서 구현을 하고 함수를 호출하는 방식으로
    //객체를 반환을 할 수가 있다. 카테고리 기반으로 전달 받겠다.
    // 그럼 position이 중요한게 아니라 카테고리가 중요한거다.
    companion object {
        fun newInstance(category: Category): CategoryArticleListFragment {
            return CategoryArticleListFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(Constants.KEY_CATEGORY, category)

                }
            }
        }
    }


    override fun onArticleClick(category: Category, article: Article) {
        val action = HomeFragmentDirections.actionHomeToArticleDetailActivity(category, article)
        findNavController().navigate(action)
    }

    private fun setLayout() {
        val adapter = CategoryArticleAdapter(category, this)
        binding.rvCategoryArticleList.adapter = adapter
        lifecycleScope.launch {
            val newsService = NewsService.create()
            val result = newsService.getTopHeadLines("kr", category.label)
            adapter.addArticles(result.articles)
        }
    }

}