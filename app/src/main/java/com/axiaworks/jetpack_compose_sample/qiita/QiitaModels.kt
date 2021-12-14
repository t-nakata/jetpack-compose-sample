package com.axiaworks.jetpack_compose_sample.qiita
import com.squareup.moshi.Json

data class QiitaInfo (
    val id: String,
    val title: String,
    val body: String,
    val url: String,
    @Json(name = "user")val qiitaUser: QiitaUser
)

data class QiitaUser (
    val profile_image_url: String
)