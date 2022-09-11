package com.example.kotlindemoapp.view_images

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ImageRetrofitClient {

    private lateinit var indiaRetrofitClient: Retrofit
    private val gson = GsonBuilder().create()
    var BASE_URL: String = "https://jsonplaceholder.typicode.com/"

    private val okHttpClient = OkHttpClient
        .Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()

    fun <T> createIndiaService(serviceClass: Class<T>?): T {
        if (!::indiaRetrofitClient.isInitialized) {
            indiaRetrofitClient = Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }
        return indiaRetrofitClient.create(serviceClass)
    }
}