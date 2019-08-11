package project.shen.wowhub.retrofit_paly

import kotlinx.coroutines.Deferred
import retrofit2.Converter
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.lang.reflect.Type
import java.text.SimpleDateFormat
import java.util.*

interface GithubInterface {
    @GET("/repos/{owner}/{repo}/contributors")
    fun contributors(@Path("owner") owner: String,
                     @Path("repo") repo: String,
                     @Query("current") now: Date): Deferred<List<Contributor>>


    data class Contributor(
        val login: String,
        val contributions: Int
    )
}

class DateConverter: Converter<Date, String> {
    companion object {
        val SIMPLE_DATE_FORMAT = SimpleDateFormat("yyyyMMdd_HHmmss")

        object DateConverterFactory: Converter.Factory() {
            override fun stringConverter(
                type: Type,
                annotations: Array<Annotation>,
                retrofit: Retrofit
            ): Converter<*, String>? {
                return if (type == Date::class.java) DateConverter()
                else super.stringConverter(type, annotations, retrofit)
            }
        }
    }

    override fun convert(value: Date): String? = SIMPLE_DATE_FORMAT.format(value)
}