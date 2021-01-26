package com.rodriguesalex.marvelapp.detail.viewmodel

import com.rodriguesalex.marvelapp.detail.data.DetailVo

sealed class DetailViewModelState {
    data class Loaded(val vo: DetailVo): DetailViewModelState()
}