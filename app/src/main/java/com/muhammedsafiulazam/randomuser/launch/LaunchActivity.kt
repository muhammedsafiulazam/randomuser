package com.muhammedsafiulazam.randomuser.launch

import android.os.Bundle
import com.muhammedsafiulazam.randomuser.Knowledge
import com.muhammedsafiulazam.randomuser.R
import com.muhammedsafiulazam.randomuser.activity.BaseActivity
import com.muhammedsafiulazam.randomuser.feature.userlist.UserListActivity

class LaunchActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
    }

    override fun onStart() {
        super.onStart()

        Knowledge.getActivityManager().loadActivity(UserListActivity::class.java)
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
