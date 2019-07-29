package project.shen.wowhub.retrofit_paly

import android.util.Log
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import project.shen.wowhub.retrofit_paly.RetrofitHelper.FALSE_API_HOST
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

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
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(DateConverter.Companion.DateConverterFactory)
            .build()
    }

    fun setHost(host: String) {
        httpUrlReflect.setHostUrl(host)
    }
}

suspend fun main() {
    val github = RetrofitHelper.retrofit.create(GithubInterface::class.java)
    RetrofitHelper.setHost(FALSE_API_HOST)
    val call = github.contributors("square", "retrofit", Date())
    val result = call.await()
    result.forEach {
        println("${it.login} (${it.contributions})")
    }
}