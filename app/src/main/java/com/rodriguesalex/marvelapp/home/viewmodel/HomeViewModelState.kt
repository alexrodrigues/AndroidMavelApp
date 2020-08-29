package com.rodriguesalex.marvelapp.home.viewmodel

import com.rodriguesalex.marvelapp.home.data.HomeCharacterVO

sealed class HomeViewModelState {
    object Loading : HomeViewModelState()
    data class Loaded(val list: List<HomeCharacterVO>) : HomeViewModelState()
}
