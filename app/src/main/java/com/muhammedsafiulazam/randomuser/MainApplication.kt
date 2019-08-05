package com.muhammedsafiulazam.randomuser

import android.app.Application

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Knowledge.initialize(this)
    }
}