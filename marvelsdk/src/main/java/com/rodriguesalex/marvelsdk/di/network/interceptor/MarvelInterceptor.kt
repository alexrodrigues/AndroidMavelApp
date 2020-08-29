package com.rodriguesalex.marvelsdk.di.network.interceptor

import com.rodriguesalex.marvelsdk.security.MarvelSecurity
import com.rodriguesalex.marvelsdk.security.MarvelSecurity.Companion.PUBLIC_KEY
import com.rodriguesalex.marvelsdk.security.MarvelSecurity.Companion.timestamp
import okhttp3.Interceptor
import okhttp3.Response

class MarvelInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()

        val url = request.url()
            .newBuilder()
            .apply {
                addQueryParameter("apikey", PUBLIC_KEY)
                addQueryParameter("ts", timestamp)
                addQueryParameter("hash", MarvelSecurity.hash())
            }
            .build()

        return chain.proceed(request.newBuilder().url(url).build())
    }
}
