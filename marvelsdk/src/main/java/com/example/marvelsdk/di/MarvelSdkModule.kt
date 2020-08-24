package com.example.marvelsdk.di

import com.example.marvelsdk.characters.CharactersRepository
import com.example.marvelsdk.characters.CharactersRepositoryImpl
import com.example.marvelsdk.characters.service.CharacterService
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
abstract class MarvelSdkModule {

    @Binds
    abstract fun provideCharactersRepository(repositoryImpl: CharactersRepositoryImpl): CharactersRepository


    companion object {

        @Provides
        fun provideCharacterService(retrofit: Retrofit): CharacterService {
            return retrofit.create(CharacterService::class.java)
        }
    }
}