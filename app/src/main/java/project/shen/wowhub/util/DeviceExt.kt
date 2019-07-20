package project.shen.wowhub.util

import android.content.Context
import android.provider.Settings

val Context.deviceId: String
    get() = Settings.Secure.getString(
        contentResolver,
        Settings.Secure.ANDROID_ID
    )