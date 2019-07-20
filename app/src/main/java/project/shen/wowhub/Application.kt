package project.shen.wowhub

import android.app.Application
import android.content.Context

class MyApplication: Application() {
    companion object {
        fun getAppContext(): Context = appContext
        private lateinit var appContext: Context
    }


    override fun onCreate() {
        super.onCreate()
        appContext = this
    }
}