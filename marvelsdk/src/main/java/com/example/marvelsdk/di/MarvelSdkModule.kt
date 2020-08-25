package com.example.marvelsdk.di

import com.example.marvelsdk.characters.CharactersRepository
import com.example.marvelsdk.characters.CharactersRepositoryImpl
import com.example.marvelsdk.di.network.NetworkModule
import dagger.Binds
import dagger.Module

@Module(includes = [NetworkModule::class])
abstract class MarvelSdkModule {

    @Binds
    abstract fun provideCharactersRepository(repositoryImpl: CharactersRepositoryImpl): CharactersRepository
}
