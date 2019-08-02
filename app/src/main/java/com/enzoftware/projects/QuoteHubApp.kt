package com.enzoftware.projects

import android.app.Application
import com.enzoftware.projects.di.components.AppComponent
import com.enzoftware.projects.di.components.DaggerAppComponent
import com.google.firebase.FirebaseApp

class QuoteHubApp : Application() {

    companion object{
        lateinit var instance : QuoteHubApp
        private set
        val component: AppComponent by lazy { DaggerAppComponent.builder().build() }
    }


    override fun onCreate() {
        super.onCreate()
        instance = this

        FirebaseApp.initializeApp(this)
    }
}