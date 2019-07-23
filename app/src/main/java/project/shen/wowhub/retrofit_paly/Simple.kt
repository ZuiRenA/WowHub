package project.shen.wowhub.retrofit_paly

import android.util.Log
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

object RetrofitHelper {

    private const val API_URL = "https://api.github.com"
    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(API_URL)
//            .client(OkHttpClient.Builder()
//                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
//                .build())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }
}

suspend fun main() {
    val github = RetrofitHelper.retrofit.create(GithubInterface::class.java)
    println(github.javaClass)
    val call = github.contributors("square", "retrofit", Date())
    val result = call.await()
    result.forEach {
        println("${it.login} (${it.contributions})")
    }
}