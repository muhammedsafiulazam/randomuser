package com.muhammedsafiulazam.randomuser.network.server

import com.muhammedsafiulazam.randomuser.network.server.user.IUserServer

interface IServerManager {
    /**
     * Get user server.
     * @return user server
     */
    fun getUserServer() : IUserServer
}