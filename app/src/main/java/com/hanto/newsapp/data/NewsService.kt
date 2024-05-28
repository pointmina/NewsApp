package com.hanto.newsapp.data

import com.hanto.newsapp.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

//인터페이스 선언추가
interface NewsService {


    @Headers("X-Api-Key: ${BuildConfig.API_KEY}")
    @GET("v2/top-headlines")
    //url 주소로 요청을 수행하게 될 함수 선언
    //response에 대응되는 kotlin 타입으로 변환이 된 결과를 받을 수 있다.

    suspend fun getTopHeadLines(
        @Query("country") country: String = "kr",
        @Query("category") category: String? = null,
//        @Header("X-Api-Key") apiKey : String
    ): TopHeadlinesResponse

    companion object {
        fun create(): NewsService {
            val logger = HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            //통신할 api의 endpoint함수로 선언한 인터페이스를 전달하면 됨
            return Retrofit.Builder()
                .baseUrl("https://newsapi.org/")
                .client(client)
                //역직렬화를 위한 컨버터 팩토리
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(NewsService::class.java)
        }
    }
}

