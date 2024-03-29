package project.shen.wowhub.network

import android.util.Log
import project.shen.wowhub.MyApplication
import project.shen.wowhub.util.deviceId

object NetworkConfig {
    object Account {
        val SCOPES = listOf("user", "repo", "notifications", "gist", "admin:org")
        const val clientId = "cccb7d70ba4fe6d4f62d"
        const val clientSecret = "30bea5fc021ed503bef21e23ce8e2b02d588ab6c"
        const val note = "kotliner.cn"
        const val noteUrl = "http://www.kotliner.cn"

        val fingerPrint by lazy {
            (MyApplication.getAppContext().deviceId + clientId).also { Log.d("NetworkConfig", it) }
        }
    }
}