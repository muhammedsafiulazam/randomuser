package com.muhammedsafiulazam.randomuser.network.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitManager : IRetrofitManager {

    private val BASE_URL_RANDOM_USER: String = "https://randomuser.me/"
    private var mRetrofit: Retrofit

    init {
        val clientBuilder = OkHttpClient.Builder()
        mRetrofit = Retrofit.Builder()
            .client(clientBuilder.build())
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(BASE_URL_RANDOM_USER)
            .build()
    }

    /**
     * Get retrofit.
     * @return retrofit
     */
    override fun getRetrofit() : Retrofit {
        return mRetrofit
    }
}