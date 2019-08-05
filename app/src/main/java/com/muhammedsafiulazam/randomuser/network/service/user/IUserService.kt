package com.muhammedsafiulazam.randomuser.network.service.user

interface IUserService {
    /**
     * Get users.
     * @param count number of users
     * @param gender gender of users
     */
    fun getUsers(count: Int?, gender: String?)
}