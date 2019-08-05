package com.muhammedsafiulazam.randomuser.network.server.user

import com.muhammedsafiulazam.randomuser.MainApplication

class UserServer {
    companion object {
        /**
         * Get user server.
         * @return user server
         */
        fun getUserServer() : IUserServer {
            return MainApplication.getInstance().getRetrofitManager().getRetrofit().create(IUserServer::class.java)
        }
    }
}