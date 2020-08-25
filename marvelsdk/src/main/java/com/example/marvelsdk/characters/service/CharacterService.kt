package com.example.marvelsdk.characters.service

import com.example.marvelsdk.characters.data.MarvelCharacterResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterService {

    @GET("characters")
    fun fetchCharacters(@Query("limit") limit: Int): Single<MarvelCharacterResponse>
}
