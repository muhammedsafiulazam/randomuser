package com.muhammedsafiulazam.randomuser.network.server.user

import com.muhammedsafiulazam.randomuser.network.model.user.Results
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IUserServer {

    @GET("api/?")
    fun getUsers(@Query("results") results: Int?, @Query("gender") gender: String?) : Call<Results>
}