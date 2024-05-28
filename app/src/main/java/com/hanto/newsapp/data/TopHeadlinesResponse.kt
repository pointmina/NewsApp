package com.hanto.newsapp.data

data class TopHeadlinesResponse(
    val status : String,
    val totalResults : Int,
    val articles : List<Article>

)
