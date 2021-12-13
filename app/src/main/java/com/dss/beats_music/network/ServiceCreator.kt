package com.dss.beats_music.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {

    private const val BASE_URL = "https://netease-cloud-music-api-jerry.vercel.app"

    private val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)      //设置网络请求的Url地址
            .addConverterFactory(GsonConverterFactory.create())     //设置数据解析器
            .build()

    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

    inline fun <reified T> create(): T = create(T::class.java)

}