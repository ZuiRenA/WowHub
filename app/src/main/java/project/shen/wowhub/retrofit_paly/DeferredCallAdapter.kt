package project.shen.wowhub.retrofit_paly

import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Deferred
import retrofit2.*
import java.lang.IllegalStateException
import java.lang.NullPointerException
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class DeferredCallAdapter private constructor(): CallAdapter.Factory() {
    companion object {
        @JvmStatic
        private val deferredAdapter = DeferredCallAdapter()

        @JvmStatic
        fun create(): DeferredCallAdapter = deferredAdapter
    }

    override fun get(returnType: Type, annotations: Array<Annotation>, retrofit: Retrofit): CallAdapter<*, *>? {
        if (getRawType(returnType) != Deferred::class.java) {
            return null
        }

        if (returnType !is ParameterizedType) {
            throw IllegalStateException("Deferred return type must be parameterized" + "as Deferred<foo> or Deferred<* extend foo>")
        }

        val innerType = getParameterUpperBound(0, returnType)

        if(getRawType(innerType) != Response::class.java) {
            return BodyDeferredAdapter<Any>(innerType)
        }

        if (innerType !is ParameterizedType) {
            throw IllegalStateException("Deferred return type must be parameterized" + "as Response<foo> or Response<* extend foo>")
        }

        val responseType = getParameterUpperBound(0, innerType)
        return ResponseDeferredAdapter<Any>(responseType)
    }
}

class ResponseDeferredAdapter<T>(private val responseType: Type): CallAdapter<T, Deferred<Response<T>>> {
    override fun adapt(call: Call<T>): Deferred<Response<T>> {
        val completableDeferred = CompletableDeferred<Response<T>>()
        call.enqueue(object : Callback<T> {
            override fun onFailure(call: Call<T>, t: Throwable) {
                completableDeferred.completeExceptionally(t)
            }

            override fun onResponse(call: Call<T>, response: Response<T>) {
                completableDeferred.complete(response)
            }
        })

        return completableDeferred
    }

    override fun responseType(): Type = responseType
}

class BodyDeferredAdapter<T>(private val responseType: Type): CallAdapter<T, Deferred<T>> {
    override fun adapt(call: Call<T>): Deferred<T> {
        val completableDeferred = CompletableDeferred<T>()
        call.enqueue(object : Callback<T> {
            override fun onFailure(call: Call<T>, t: Throwable) {
                completableDeferred.completeExceptionally(t)
            }

            override fun onResponse(call: Call<T>, response: Response<T>) {
                response.body()?.let(completableDeferred::complete)
                    ?: completableDeferred.completeExceptionally(NullPointerException())
            }
        })

        return completableDeferred
    }

    override fun responseType(): Type = responseType
}