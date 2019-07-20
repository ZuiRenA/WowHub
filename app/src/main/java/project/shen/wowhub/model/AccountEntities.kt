package project.shen.wowhub.model

import project.shen.wowhub.network.NetworkConfig

data class AuthorizationReq(
    var scopes: List<String> = NetworkConfig.Account.SCOPES,
    var note: String = NetworkConfig.Account.note,
    var note_url: String = NetworkConfig.Account.noteUrl,
    var client_secret: String = NetworkConfig.Account.clientSecret
)

data class AuthorizationRsp(
    var id: Int,
    var url: String,
    var app: App,
    var token: String,
    var hashed_token: String,
    var token_last_eight: String,
    var note: String,
    var note_url: String,
    var created_at: String,
    var updated_at: String,
    var scopes: List<String>
)

data class App(
    var name: String,
    var url: String,
    var client_id: String
)