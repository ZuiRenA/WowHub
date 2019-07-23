package project.shen.wowhub.retrofit_paly

import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
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