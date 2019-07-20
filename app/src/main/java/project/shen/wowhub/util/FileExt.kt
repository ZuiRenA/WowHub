package project.shen.wowhub.util

import android.util.Log
import java.io.File
import java.lang.Exception

fun File.ensuereDir(): Boolean {
    try {
        if (isDirectory) {
            if (isFile)
                delete()
            return mkdirs()
        }
    } catch (e: Exception) {
        Log.w("ensureDir error", e.message)
    }

    return false
}