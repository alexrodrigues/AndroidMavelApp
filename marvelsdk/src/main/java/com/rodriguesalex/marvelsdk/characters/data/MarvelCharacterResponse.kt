package com.rodriguesalex.marvelsdk.characters.data

data class MarvelCharacterResponse(
    val attributionText: String? = null,
    val data: MarvelCharacterDataResponse? = null
)

data class MarvelCharacterDataResponse(
    val offset: Int? = null,
    val limit: Int? = null,
    val results: List<MarvelCharacter>? = null
)
