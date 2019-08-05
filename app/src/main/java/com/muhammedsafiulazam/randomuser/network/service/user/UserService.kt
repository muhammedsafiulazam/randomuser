package com.muhammedsafiulazam.randomuser.network.service.user

import com.muhammedsafiulazam.randomuser.Knowledge
import com.muhammedsafiulazam.randomuser.event.Event
import com.muhammedsafiulazam.randomuser.network.event.UserEventType
import com.muhammedsafiulazam.randomuser.network.model.Error
import com.muhammedsafiulazam.randomuser.network.model.user.Results
import com.muhammedsafiulazam.randomuser.network.server.IServerManager
import retrofit2.Call
import retrofit2.Response

class UserService : IUserService {
    /**
     * Get users.
     * @param count number of users
     * @param gender gender of users
     */
    override fun getUsers(count: Int?, gender: String?) {
        // Server manager.
        val serverManager: IServerManager = Knowledge.getServerManager()

        // Service call.
        val call: Call<Results> = serverManager.getUserServer().getUsers(count, gender)

        // Queue manager.
        Knowledge.getQueueManager().execute(call as Call<Any>, callback = { response: Response<Any> ->
            var results: Results? = null
            var error: Error? = null

            if (response.isSuccessful()) {
                results = (response as Response<Results>).body()
            } else {
                error = Error(response.code(), response.errorBody()?.toString())
            }

            val event: Event = Event(UserEventType.GET_USERS, results, error)
            Knowledge.getEventManager().send(event)
        })
    }
}