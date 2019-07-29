package project.shen.wowhub.retrofit_paly

import okhttp3.HttpUrl
import java.lang.reflect.Field

class HttpUrlReflect(val httpUrl: HttpUrl) {
    private var hostField: Field?

    init {
        var field: Field? = null

        try {
            field = HttpUrl::class.java.getDeclaredField("host")
                .apply {
                    isAccessible = true
                }
        } catch (e: NoSuchFileException) {
            e.printStackTrace()
        }

        hostField = field
    }

    fun setHostUrl(host: String) {
        try {
            hostField?.set(httpUrl, host)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}