package com.enzoftware.projects

import android.app.Application
import com.enzoftware.projects.di.components.ApplicationComponent

class QuoteHubApp : Application() {

    companion object{
        lateinit var instance : QuoteHubApp
        private set
        val component: ApplicationComponent by lazy { DaggerAppComponent.builder.build() }
    }


    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}