package com.muhammedsafiulazam.randomuser.network.server

import com.muhammedsafiulazam.randomuser.network.server.user.IUserServer
import com.muhammedsafiulazam.randomuser.network.server.user.UserServer

class ServerManager : IServerManager {

    private val mUserServer: IUserServer by lazy {
        UserServer.getUserServer()
    }

    /**
     * Get user server.
     * @return user server
     */
    override fun getUserServer() : IUserServer {
        return mUserServer
    }
}