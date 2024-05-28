package com.hanto.newsapp.ui

import com.hanto.newsapp.data.Article
import com.hanto.newsapp.data.Category

interface ArticleClickListener {
    fun onArticleClick(category: Category, article: Article)
}