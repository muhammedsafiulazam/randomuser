package com.muhammedsafiulazam.randomuser.feature.userlist

import android.text.TextUtils
import com.muhammedsafiulazam.randomuser.Knowledge
import com.muhammedsafiulazam.randomuser.R
import com.muhammedsafiulazam.randomuser.activity.BaseActivityModel
import com.muhammedsafiulazam.randomuser.event.Event
import com.muhammedsafiulazam.randomuser.feature.userlist.event.UserListEventType
import com.muhammedsafiulazam.randomuser.network.event.UserEventType
import com.muhammedsafiulazam.randomuser.network.model.user.Results
import com.muhammedsafiulazam.randomuser.network.model.user.User
import kotlinx.coroutines.channels.ReceiveChannel

/**
 * Created by Muhammed Safiul Azam on 25/07/2019.
 */

class UserListActivityModel : BaseActivityModel() {
    companion object {
        const val COUNT_USERS: Int = 100
    }

    private var mReceiveChannel: ReceiveChannel<Event>? = null
    private val mUserList: MutableList<User> = mutableListOf()

    override fun onCreateActivity() {
        super.onCreateActivity()
        subscribeToEvents()

        // Load users.
        loadDataRequest()
    }

    override fun onStartActivity() {
        super.onStartActivity()
        subscribeToEvents()
    }

    override fun onStopActivity() {
        unsubscribeFromEvents()
        super.onStopActivity()
    }

    private fun subscribeToEvents() {
        mReceiveChannel = Knowledge.getEventManager().subscribe( callback = { event : Event -> Unit
            onReceiveEvents(event)
        })
    }

    private fun unsubscribeFromEvents() {
        Knowledge.getEventManager().unsubscribe(mReceiveChannel)
    }

    private fun loadDataBusy(busy: Boolean) {
        val event: Event = Event(UserListEventType.LOAD_DATA_BUSY, busy, null)
        Knowledge.getEventManager().send(event)
    }

    private fun loadDataError(error: String?) {
        val event: Event = Event(UserListEventType.LOAD_DATA_ERROR, error, null)
        Knowledge.getEventManager().send(event)
    }

    private fun loadDataResponse(response: List<User>) {
        val event: Event = Event(UserListEventType.LOAD_DATA_RESPONSE, response, null)
        Knowledge.getEventManager().send(event)
    }

    fun loadDataRequest() {
        // Show loader.
        loadDataBusy(true)

        // Call for users.
        Knowledge.getServiceManager().getUserService().getUsers(COUNT_USERS, null)
    }

    fun onReceiveEvents(event: Event) {
        if (TextUtils.equals(UserListEventType.LOAD_DATA_REQUEST, event.type)) {
            // Load users.
            loadDataRequest()
        } else if (TextUtils.equals(UserEventType.GET_USERS, event.type)) {

            // Hide loader.
            loadDataBusy(false)

            if (event.error != null) {
                // Show message.
                loadDataError(getActivity()?.getString(R.string.userlist_error_users))
            } else {

                mUserList.clear()
                if (event.data != null) {
                    val results: Results = event.data as Results
                    mUserList.addAll(results.results!!)
                }

                // Update view.
                loadDataResponse(mUserList)
            }
        }
    }

    override fun onDestroyActivity() {
        unsubscribeFromEvents()
        super.onDestroyActivity()
    }
}