package com.enzoftware.projects

import android.app.Application

class QuoteHubApp : Application() {

    companion object{
        lateinit var instance : QuoteHubApp
        private set

    }


}