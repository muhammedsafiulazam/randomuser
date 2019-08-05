package com.muhammedsafiulazam.randomuser.feature.userlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muhammedsafiulazam.randomuser.R
import com.muhammedsafiulazam.randomuser.network.model.user.User

class UserListAdapter(val userlist: MutableList<User>, val userListListener: IUserListListener) : RecyclerView.Adapter<UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_userlist_item, parent, false),
            userListListener
        )
    }

    override fun getItemCount(): Int {
        return userlist.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user: User = userlist.get(position);
        holder.bind(user)
    }
}