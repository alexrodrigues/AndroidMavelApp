package com.example.marvelsdk.characters.service

import com.example.marvelsdk.characters.data.MarvelCharacterResponse
import io.reactivex.Single
import retrofit2.http.GET

interface CharacterService {

    @GET("/character")
    fun fetchCharacters(limit: Int): Single<MarvelCharacterResponse>

}