package com.hanto.newsapp.ui

import com.hanto.newsapp.ui.adapter.LatestArticleAdapter
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
import com.hanto.newsapp.databinding.FragmentLatestBinding
import kotlinx.coroutines.launch

class LatestFragment : Fragment(), ArticleClickListener {

    private var _binding: FragmentLatestBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLatestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setLayout()

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onArticleClick(category: Category, article: Article) {
        val action = LatestFragmentDirections.actionLatestArticlesToArticleDetailActivity(category, article)
        findNavController().navigate(action)
    }

    private fun setLayout() {
        val adapter = LatestArticleAdapter(this)
        //어뎁터 초기화
        binding.rvLatestArticleList.adapter = adapter
        //데이터 삽입
        lifecycleScope.launch {
            val newsService = NewsService.create()
            val result = newsService.getTopHeadLines()
            adapter.addArticles(result.articles)
        }

    }


}

