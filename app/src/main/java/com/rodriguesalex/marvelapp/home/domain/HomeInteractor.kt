package com.rodriguesalex.marvelapp.home.domain

import com.rodriguesalex.marvelapp.home.data.HomeCharacterVO
import com.rodriguesalex.marvelapp.home.domain.mapper.toVoList
import com.rodriguesalex.marvelsdk.characters.CharactersRepository
import io.reactivex.Single
import javax.inject.Inject

interface HomeInteractor {
    fun fetchCharacters(): Single<List<HomeCharacterVO>>
}

class HomeInteractorImpl @Inject constructor(
    private val repository: CharactersRepository
) : HomeInteractor {

    override fun fetchCharacters() =
        repository.fetchCharacters()
            .map {
                it.toVoList()
            }
}
