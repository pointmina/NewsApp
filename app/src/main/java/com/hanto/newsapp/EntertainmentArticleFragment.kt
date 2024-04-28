package com.hanto.newsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hanto.newsapp.databinding.FragmentCategoryArticleListBinding

class EntertainmentArticleFragment : Fragment() {
    private var _binding: FragmentCategoryArticleListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoryArticleListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val items = mutableListOf<Article>()
        //요기부분만 api에 따라 바뀜 데이터만 바꾸면 됨 ㅇㅇ
        repeat(10) {
            items.add(Article("Entertainment title $it"))
        }
        binding.rvCategoryArticleList.adapter = CategoryArticleAdapter(items)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}