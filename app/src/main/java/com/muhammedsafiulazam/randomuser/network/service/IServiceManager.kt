package com.muhammedsafiulazam.randomuser.network.service

import com.muhammedsafiulazam.randomuser.network.service.user.IUserService

interface IServiceManager {
    /**
     * Get user service.
     * @return user service
     */
    fun getUserService() : IUserService
}