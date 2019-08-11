package project.shen.wowhub.retrofit_paly

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Method
import java.util.*
import kotlin.reflect.full.declaredFunctions
import kotlin.reflect.full.declaredMemberFunctions

object RetrofitHelper {

    private const val API_URL = "https://api.github.com"

    const val FALSE_API_HOST = "false.api.github.com"

    private val httpUrlReflect = HttpUrlReflect(HttpUrl.get(API_URL))

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(httpUrlReflect.httpUrl)
            .client(OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor(::print).setLevel(HttpLoggingInterceptor.Level.BODY))
                .build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(DeferredCallAdapter.create())
            .addConverterFactory(DateConverter.Companion.DateConverterFactory)
            .build()
    }

    fun setHost(host: String) {
        httpUrlReflect.setHostUrl(host)
    }
}

suspend fun main() {
    val github = RetrofitHelper.retrofit.create(GithubInterface::class.java)
    val call = github.contributors("square", "retrofit", Date())
    val result = call.await()
    result.forEach {
        println("${it.login} (${it.contributions})")
    }
}