package com.muhammedsafiulazam.randomuser

import android.content.Context
import android.content.res.Resources
import com.muhammedsafiulazam.randomuser.activity.ActivityManager
import com.muhammedsafiulazam.randomuser.activity.IActivityManager
import com.muhammedsafiulazam.randomuser.event.EventManager
import com.muhammedsafiulazam.randomuser.event.IEventManager
import com.muhammedsafiulazam.randomuser.network.queue.IQueueManager
import com.muhammedsafiulazam.randomuser.network.queue.QueueManager
import com.muhammedsafiulazam.randomuser.network.retrofit.IRetrofitManager
import com.muhammedsafiulazam.randomuser.network.retrofit.RetrofitManager
import com.muhammedsafiulazam.randomuser.network.server.IServerManager
import com.muhammedsafiulazam.randomuser.network.server.ServerManager
import com.muhammedsafiulazam.randomuser.network.service.IServiceManager
import com.muhammedsafiulazam.randomuser.network.service.ServiceManager

object Knowledge {

    // Context.
    private var mContext: Context? = null

    // Activity manager.
    private val mActivityManager: IActivityManager by lazy {
        ActivityManager()
    }

    // Server manager.
    private val mServerManager: IServerManager by lazy {
        ServerManager()
    }

    // Service manager.
    private val mServiceManager: IServiceManager by lazy {
        ServiceManager()
    }

    // Event manager.
    private val mEventManager: IEventManager by lazy {
        EventManager()
    }

    // Retrofit manager.
    private val mRetrofitManger: IRetrofitManager by lazy {
        RetrofitManager()
    }

    // Queue manager.
    private val mQueueManager: IQueueManager by lazy {
        QueueManager()
    }

    /**
     * Initialize with context.
     * @param context context
     */
    fun initialize(context: Context) {
        mContext = context
    }

    /**
     * Get context.
     * @return context
     */
    fun getContext() : Context {
        return mContext!!
    }

    /**
     * Get resources.
     * @return resources
     */
    fun getResources() : Resources {
        return mContext!!.resources
    }

    /**
     * Get activity manager.
     * @return activity manager
     */
    fun getActivityManager() : IActivityManager {
        return mActivityManager
    }

    /**
     * Get server manager.
     * @return server manager
     */
    fun getServerManager() : IServerManager {
        return mServerManager
    }

    /**
     * Get service manager.
     * @return service manager
     */
    fun getServiceManager() : IServiceManager {
        return mServiceManager
    }

    /**
     * Get event manager.
     * @return event manager
     */
    fun getEventManager() : IEventManager {
        return mEventManager
    }

    /**
     * Get retrofit manager.
     * @return retrofit manager
     */
    fun getRetrofitManager() : IRetrofitManager {
        return mRetrofitManger
    }

    /**
     * Get queue manager.
     * @return queue manager
     */
    fun getQueueManager() : IQueueManager {
        return mQueueManager
    }
}