package com.jfaf.elpuntuador

import android.app.Application


class App : Application(){

    override fun onCreate() {
        super.onCreate()
        initDi()
    }
}