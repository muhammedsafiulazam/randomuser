package com.muhammedsafiulazam.randomuser.network.retrofit

import retrofit2.Retrofit

interface IRetrofitManager {
    /**
     * Get retrofit.
     * @return retrofit
     */
    fun getRetrofit() : Retrofit
}