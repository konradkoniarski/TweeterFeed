package mvt.co.uk.tweeterfeed.service

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Copyright (c) 2020 Mobile Vision Technologies LTD. All rights reserved.
 * Created on 2020-02-09.
 */
class NetworkService(val settingService: SettingService) {

    fun getTweeterFeedApi(): TweeterFeedApi {
        val baseUrl = settingService.getCakeApiUrl()
        val builder = OkHttpClient.Builder()
        builder.interceptors().add(AuthInterceptor(settingService))
        builder.interceptors().add(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        val client = builder.build()

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(
                MoshiConverterFactory.create(moshi).asLenient()
            )
            .client(client)
            .build()
            .create(TweeterFeedApi::class.java)
    }
}