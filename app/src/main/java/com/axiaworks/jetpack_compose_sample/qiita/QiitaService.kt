package com.axiaworks.jetpack_compose_sample.qiita

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

interface QiitaService {
    @GET("/api/v2/tags/{tag}/items?per_page=50")
    suspend fun fetchItemsByTag(
        @Path("tag") tag: String,
        @Query("page") page: Int
    ): List<QiitaInfo>

    companion object {
        var qiitaService: QiitaService? = null
        fun getInstance(): QiitaService {
            if (qiitaService == null) {
                qiitaService = Retrofit.Builder()
                    .baseUrl("https://qiita.com")
                    .addConverterFactory(
                        MoshiConverterFactory.create(
                            Moshi.Builder()
                                .add(KotlinJsonAdapterFactory())
                                .build()
                        )
                    )
                    .client(
                        OkHttpClient
                            .Builder()
                            .addInterceptor(
                                HttpLoggingInterceptor().apply {
                                    level = HttpLoggingInterceptor.Level.BASIC
                                })
//                    .addInterceptor(
//                        HttpLoggingInterceptor().apply {
//                            level = HttpLoggingInterceptor.Level.HEADERS
//                        }
//                    )
//                    .addInterceptor(
//                        HttpLoggingInterceptor().apply {
//                            level = HttpLoggingInterceptor.Level.BODY
//                        }
//                    )
                            .build()
                    )
                    .build()
                    .create(QiitaService::class.java)
            }
            return qiitaService!!
        }
    }
}