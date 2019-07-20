package project.shen.wowhub.network

import kotlinx.coroutines.Deferred
import project.shen.wowhub.model.AuthorizationReq
import project.shen.wowhub.model.AuthorizationRsp
import retrofit2.Response
import retrofit2.http.*

interface Api {

    @PUT("/authorizations/clients/${NetworkConfig.Account.clientId}/{fingerPrint}")
    fun createAuthorization(@Path("fingerPrint") fingerPrint: String = NetworkConfig.Account.fingerPrint,
                            @Body req: AuthorizationReq): Deferred<AuthorizationRsp>

    @DELETE("/authorizations/{id}")
    fun deleteAuthorization(@Path("id") id: Int): Deferred<Response<Any>>
}

object AuthService: Api by retrofit.create(Api::class.java)