package com.rodriguesalex.marvelapp.detail.viewmodel

import com.rodriguesalex.marvelapp.home.data.HomeCharacterVO

sealed class DetailViewModelState {
    data class Loaded(val vo: HomeCharacterVO): DetailViewModelState()
}