package com.muhammedsafiulazam.randomuser.event

import com.muhammedsafiulazam.randomuser.network.model.Error

/**
 * Created by Muhammed Safiul Azam on 24/07/2019.
 */

data class Event (val type: String, val data: Any? = null, val error: Error? = null)