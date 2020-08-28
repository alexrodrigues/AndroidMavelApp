package com.rodriguesalex.marvelsdk.characters.data

data class MarvelCharacter(
    val id: String? = null,
    val name: String? = null,
    val description: String? = null,
    val resourceURI: String? = null,
    val thumbnail: MarvelCharacterThumbnail? = null,
    val comics: MarvelCharacterSummary? = null,
    val series: MarvelCharacterSummary? = null,
    val stories: MarvelCharacterSummary? = null,
    val events: MarvelCharacterSummary? = null
)
