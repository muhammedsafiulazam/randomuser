package com.muhammedsafiulazam.randomuser.network.service

import com.muhammedsafiulazam.randomuser.network.service.user.IUserService
import com.muhammedsafiulazam.randomuser.network.service.user.UserService


class ServiceManager : IServiceManager {
    private val mUserService: IUserService by lazy {
        UserService()
    }

    /**
     * Get user service.
     * @return user service
     */
    override fun getUserService() : IUserService {
        return mUserService
    }
}