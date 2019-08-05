package com.muhammedsafiulazam.randomuser.feature.userinfo

import android.os.Bundle
import android.view.View
import com.muhammedsafiulazam.randomuser.R
import com.muhammedsafiulazam.randomuser.activity.BaseActivity
import com.muhammedsafiulazam.randomuser.network.model.user.User
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_userinfo.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UserInfoActivity : BaseActivity() {
    private lateinit var mUser: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userinfo)
        setActivityModel(UserInfoActivityModel::class.java)
        mUser = getData() as User
        updateView(mUser)
    }

    private fun updateView(user: User) {

        userinfo_txv_title_name.text = getString(R.string.userinfo_title_name)
        userinfo_txv_value_name.text = user.name?.first?.capitalize() + " " + user.name?.last?.capitalize()
        userinfo_txv_title_email.text = getString(R.string.userinfo_title_email)
        userinfo_txv_value_email.text = user.email
        userinfo_txv_title_phone.text = getString(R.string.userinfo_title_phone)
        userinfo_txv_value_phone.text = user.phone
        userinfo_pgb_picture.visibility = View.VISIBLE

        GlobalScope.launch (Dispatchers.Main) {
            Picasso.get().load(user.picture?.large).into(userinfo_imv_picture, object: Callback {
                override fun onSuccess() {
                    userinfo_pgb_picture.visibility = View.GONE
                }

                override fun onError(e: Exception) {
                    userinfo_pgb_picture.visibility = View.GONE
                }
            })
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
