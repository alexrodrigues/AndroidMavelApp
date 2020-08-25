package com.example.marvelsdk.di.interceptor

import com.example.marvelsdk.security.MarvelSecurity
import com.example.marvelsdk.security.MarvelSecurity.Companion.PUBLIC_KEY
import com.example.marvelsdk.security.MarvelSecurity.Companion.timestamp
import okhttp3.Interceptor
import okhttp3.Response

class MarvelInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val tempRequest = chain.request()

        val url = tempRequest.url()
            .newBuilder()
            .apply {
                addQueryParameter("apikey", PUBLIC_KEY)
                addQueryParameter("ts", timestamp)
                addQueryParameter("hash", MarvelSecurity.hash())
            }
            .build()

        val newBuilder = tempRequest.newBuilder().url(url)
        val finalRequsst = newBuilder.build()

        return chain.proceed(finalRequsst)
    }
}
