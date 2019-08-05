package com.muhammedsafiulazam.randomuser.feature.userlist

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.muhammedsafiulazam.randomuser.Knowledge
import com.muhammedsafiulazam.randomuser.R
import com.muhammedsafiulazam.randomuser.activity.BaseActivity
import com.muhammedsafiulazam.randomuser.event.Event
import com.muhammedsafiulazam.randomuser.feature.userinfo.UserInfoActivity
import com.muhammedsafiulazam.randomuser.feature.userlist.event.UserListEventType
import com.muhammedsafiulazam.randomuser.network.model.user.User
import kotlinx.android.synthetic.main.activity_userlist.*
import kotlinx.coroutines.channels.ReceiveChannel

class UserListActivity : BaseActivity(), IUserListListener {
    private var mReceiveChannel: ReceiveChannel<Event>? = null
    private val mUserList: MutableList<User> = mutableListOf()
    private val mUserListAdapter: UserListAdapter by lazy {
        UserListAdapter(mUserList, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_userlist)
        setActivityModel(UserListActivityModel::class.java)

        updateMessage(null)
        updateLoader(false)

        // Initialize recycler view.
        userlist_ryv_users.setLayoutManager(LinearLayoutManager(this))
        userlist_ryv_users.adapter = mUserListAdapter

        userlist_btn_retry.setOnClickListener(View.OnClickListener {
            onClickRetry()
        })
    }

    override fun onStart() {
        super.onStart()
        subscribeToEvents()
    }

    override fun onStop() {
        super.onStop()
        unsubscribeFromEvents()
    }

    private fun subscribeToEvents() {
        mReceiveChannel = Knowledge.getEventManager().subscribe( callback = { event : Event -> Unit
            onReceiveEvents(event)
        })
    }

    private fun unsubscribeFromEvents() {
        Knowledge.getEventManager().unsubscribe(mReceiveChannel)
    }

    fun updateLoader(show: Boolean) {
        if (show) {
            userlist_pgb_loader.visibility = View.VISIBLE
            updateMessage(null)
        } else {
            userlist_pgb_loader.visibility = View.GONE
        }
    }

    fun updateMessage(message: String?) {
        if (message != null) {
            userlist_txv_message.text = message
            userlist_txv_message.visibility = View.VISIBLE
            userlist_btn_retry.visibility = View.VISIBLE
            updateLoader(false)
        } else {
            userlist_txv_message.visibility = View.GONE
            userlist_btn_retry.visibility = View.GONE
        }
    }

    fun updateView(userList: List<User>) {
        mUserList.clear()
        mUserList.addAll(userList)
        mUserListAdapter.notifyDataSetChanged()
    }

    fun onReceiveEvents(event: Event) {
        if (TextUtils.equals(UserListEventType.LOAD_DATA_BUSY, event.type)) {
            updateLoader(event.data as Boolean)
        } else if (TextUtils.equals(UserListEventType.LOAD_DATA_ERROR, event.type)) {
            updateMessage(event.data as String)
        } else if (TextUtils.equals(UserListEventType.LOAD_DATA_RESPONSE, event.type)) {
            val userList: List<User> = event.data as List<User>
            updateView(userList)
        }
    }

    override fun onClickUser(user: User) {
        Knowledge.getActivityManager().loadActivity(UserInfoActivity::class.java, user)
    }

    private fun onClickRetry() {
        val event: Event = Event(UserListEventType.LOAD_DATA_REQUEST, null, null)
        Knowledge.getEventManager().send(event)
    }

    override fun onDestroy() {
        unsubscribeFromEvents()
        super.onDestroy()
    }
}
