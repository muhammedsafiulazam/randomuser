package com.muhammedsafiulazam.randomuser.network.queue

import retrofit2.Call
import retrofit2.Response

/**
 * Created by Muhammed Safiul Azam on 24/07/2019.
 */

interface IQueueManager {
    /**
     * Execute call and response via callback.
     * @param call execute call
     * @param callback callback for response
     */
    fun execute(call: Call<Any>, callback: (response: Response<Any>) -> Unit)

    /**
     * Shutdown manager.
     */
    fun shutdown()
}