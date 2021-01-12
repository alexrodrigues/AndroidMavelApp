package com.rodriguesalex.marvelapp.home.domain.mapper

import com.rodriguesalex.marvelapp.home.data.CharacterDetailsVO
import com.rodriguesalex.marvelapp.home.data.HomeCharacterVO
import com.rodriguesalex.marvelsdk.characters.data.MarvelCharacter
import com.rodriguesalex.marvelsdk.characters.data.MarvelCharacterThumbnail

fun List<MarvelCharacter>.toVoList(): List<HomeCharacterVO> =
    map {
        it.toVo()
    }

fun MarvelCharacter.toVo(): HomeCharacterVO =
    HomeCharacterVO(
        id = id ?: "",
        name = name ?: "John Doe",
        description = description ?: "",
        urlImage = thumbnail?.toUri() ?: "",
        details = CharacterDetailsVO(
            series = series?.items?.map { it.name ?: "" } ?: listOf(),
            comics = comics?.items?.map { it.name ?: "" } ?: listOf(),
            stories = stories?.items?.map { it.name ?: "" } ?: listOf()
        )
    )

fun MarvelCharacterThumbnail.toUri() =
    "$path/portrait_xlarge.$imageExtension"
