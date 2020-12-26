package com.rodriguesalex.marvelapp.home.viewmodel

import com.rodriguesalex.marvelapp.home.data.HomeCharacterVO

sealed class HomeViewModelCommand {
    data class OpenDetail(val vo: HomeCharacterVO): HomeViewModelCommand()
}