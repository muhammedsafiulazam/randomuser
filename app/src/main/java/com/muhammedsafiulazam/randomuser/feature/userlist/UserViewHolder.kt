package com.muhammedsafiulazam.randomuser.feature.userlist

import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.muhammedsafiulazam.randomuser.R
import com.muhammedsafiulazam.randomuser.network.model.user.User
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewHolder(view: View, userListListener: IUserListListener) : RecyclerView.ViewHolder(view){
    private var mUser: User? = null;
    private var mTxvName: AppCompatTextView? = null
    private var mTxvEmail: AppCompatTextView? = null
    private var mTxvPhone: AppCompatTextView? = null
    private var mImvPicture: AppCompatImageView? = null
    private var mPgbPicture: ProgressBar? = null

    init {
        mTxvName = view.findViewById(R.id.userlist_txv_name)
        mTxvEmail = view.findViewById(R.id.userlist_txv_email)
        mTxvPhone = view.findViewById(R.id.userlist_txv_phone)
        mImvPicture = view.findViewById(R.id.userlist_imv_picture)
        mPgbPicture = view.findViewById(R.id.userlist_pgb_picture)
        mPgbPicture?.visibility = View.GONE

        view.setOnClickListener {
            userListListener.onClickUser(mUser!!)
        }
    }

    fun bind(user: User) {
        this.mUser = user

        mTxvName!!.text = user.name?.first?.capitalize() + " " + user.name?.last?.capitalize()
        mTxvEmail!!.text = user.email
        mTxvPhone!!.text = user.phone
        mPgbPicture?.visibility = View.VISIBLE

        CoroutineScope(Dispatchers.Main).launch {
            Picasso.get().load(user.picture?.medium).into(mImvPicture, object: Callback {
                override fun onSuccess() {
                    mPgbPicture?.visibility = View.GONE
                }

                override fun onError(e: Exception) {
                    mPgbPicture?.visibility = View.GONE
                }
            })
        }
    }
}