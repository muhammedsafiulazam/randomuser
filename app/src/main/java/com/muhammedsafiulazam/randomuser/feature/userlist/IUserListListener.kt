package com.muhammedsafiulazam.randomuser.feature.userlist

import com.muhammedsafiulazam.randomuser.network.model.user.User

interface IUserListListener {
    fun onClickUser(user: User)
}