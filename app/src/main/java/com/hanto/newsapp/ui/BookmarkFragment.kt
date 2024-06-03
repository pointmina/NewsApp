package com.hanto.newsapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hanto.newsapp.R
import com.hanto.newsapp.data.Article
import com.hanto.newsapp.data.Category
import com.hanto.newsapp.databinding.FragmentBookmarkBinding
import com.hanto.newsapp.ui.adapter.BookmarkAdapter

class BookmarkFragment : Fragment () {

    private var _binding : FragmentBookmarkBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookmarkBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvBookmarkArticleList.adapter = BookmarkAdapter()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }



}
