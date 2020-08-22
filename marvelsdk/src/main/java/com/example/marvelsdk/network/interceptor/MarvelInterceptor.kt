package com.example.marvelsdk.network.interceptor

import com.example.marvelsdk.network.security.MarvelSecurity
import com.example.marvelsdk.network.security.MarvelSecurity.Companion.PUBLIC_KEY
import com.example.marvelsdk.network.security.MarvelSecurity.Companion.timestamp
import okhttp3.Interceptor
import okhttp3.Response

class MarvelInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()

        request.url()
            .newBuilder()
            .addQueryParameter("apikey", PUBLIC_KEY)
            .addQueryParameter("ts", timestamp)
            .addQueryParameter("hash", MarvelSecurity.hash())
            .build()


        return chain.proceed(request)
    }


}