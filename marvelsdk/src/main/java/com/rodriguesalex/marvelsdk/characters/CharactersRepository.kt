package com.rodriguesalex.marvelsdk.characters

import com.rodriguesalex.marvelsdk.characters.data.MarvelCharacter
import com.rodriguesalex.marvelsdk.characters.service.CharacterService
import io.reactivex.Single
import javax.inject.Inject

interface CharactersRepository {
    fun fetchCharacters(): Single<List<MarvelCharacter>?>
}

class CharactersRepositoryImpl @Inject constructor(
    private val service: CharacterService
) : CharactersRepository {

    override fun fetchCharacters() =
        service.fetchCharacters(LIMIT)
            .map {
                it.data?.results
            }

    companion object {
        private const val LIMIT = 20
    }
}
