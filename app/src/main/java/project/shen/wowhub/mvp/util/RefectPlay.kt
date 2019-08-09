package project.shen.wowhub.mvp.util

import android.app.Activity
import android.content.Intent
import android.os.BaseBundle
import android.os.Bundle
import android.os.Parcelable
import project.shen.wowhub.R
import project.shen.wowhub.retrofit_paly.GithubInterface
import java.io.Serializable
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.util.*
import kotlin.Unit

inline fun <reified T: Any> getGenericsFirst(): Type? {
    val type = object : TypeReference<T>() {}.type
    if (type is ParameterizedType) type.actualTypeArguments.first {
        true
    }.let {
        return it
    }

    return null
}

abstract class TypeReference<T>: Comparable<T> {
    val type: Type = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]

    override fun compareTo(other: T): Int = 0
}

inline fun <reified T: Activity, reified R: Any> Activity.goto(block:() -> R) {
    val intent = Intent(this, T::class.java)
    val type = getGenericsFirst<R>()
    type?.let {
        if (type != Unit.javaClass) {
            val map = (block() as BundleType<*>).map
            map.forEach {
                switchValue(intent = intent, key = it.key, value = it.value)
            }
        }
    }
    startActivity(intent)
}

class BundleType<R> (val map: Map<String, Any>)

fun switchValue(intent: Intent, key: String, value: Any) {
    when (value) {
        is Bundle -> intent.putExtra(key, value)
        is Parcelable -> intent.putExtra(key, value)
        is Serializable -> intent.putExtra(key, value)
        is ArrayList<*> -> intent.putExtra(key, value)
        is Boolean -> intent.putExtra(key, value)
        is Byte -> intent.putExtra(key, value)
        is Char -> intent.putExtra(key, value)
        is CharSequence -> intent.putExtra(key, value)
        is Double -> intent.putExtra(key, value)
        is Float -> intent.putExtra(key, value)
        is Int -> intent.putExtra(key, value)
        is Long -> intent.putExtra(key, value)
        is Short -> intent.putExtra(key, value)
        is String -> intent.putExtra(key, value)
        is Array<*> -> intent.putExtra(key, value)
        is IntArray -> intent.putExtra(key, value)
        is BooleanArray -> intent.putExtra(key, value)
        is ByteArray -> intent.putExtra(key, value)
        is CharArray -> intent.putExtra(key, value)
        is DoubleArray -> intent.putExtra(key, value)
        is FloatArray -> intent.putExtra(key, value)
        is LongArray -> intent.putExtra(key, value)
        is ShortArray -> intent.putExtra(key, value)
        else -> throw RuntimeException("Intent Have Error value type")
    }
}
