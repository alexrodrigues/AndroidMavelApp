package com.example.marvelsdk.characters.service

import retrofit2.http.GET

interface CharacterService {

    @GET("/character")
    fun fetchCharacters()

}