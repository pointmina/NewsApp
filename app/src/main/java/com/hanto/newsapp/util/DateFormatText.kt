package com.hanto.newsapp.util

import java.text.SimpleDateFormat
import java.util.Locale

object DateFormatText {
    fun convert(dateString: String): String {
        val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.KOREA)
        val date = simpleDateFormat.parse(dateString)
        val newFormat = SimpleDateFormat("yyyy/MM/dd", Locale.KOREA)
        return date?.let { newFormat.format(it) } ?: ""

    }
}