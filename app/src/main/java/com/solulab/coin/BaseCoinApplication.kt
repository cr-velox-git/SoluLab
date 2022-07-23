package com.solulab.coin

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseCoinApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        //do nothing
    }
}