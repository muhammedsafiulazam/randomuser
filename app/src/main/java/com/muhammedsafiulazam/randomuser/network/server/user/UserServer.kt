package com.muhammedsafiulazam.randomuser.network.server.user

import com.muhammedsafiulazam.randomuser.Knowledge

class UserServer {
    companion object {
        /**
         * Get user server.
         * @return user server
         */
        fun getUserServer() : IUserServer {
            return Knowledge.getRetrofitManager().getRetrofit().create(IUserServer::class.java)
        }
    }
}