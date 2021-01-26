package com.rodriguesalex.marvelapp.detail.viewmodel

import androidx.lifecycle.MutableLiveData
import com.rodriguesalex.commoms.base.BaseViewModel
import com.rodriguesalex.commoms.di.AppSchedulers
import com.rodriguesalex.marvelapp.detail.domain.DetailInteractor
import com.rodriguesalex.marvelapp.home.data.HomeCharacterVO
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    private val vo: HomeCharacterVO?,
    private val interactor: DetailInteractor
): BaseViewModel() {

    val state = MutableLiveData<DetailViewModelState>()

    override fun onCreate() {
        super.onCreate()
        vo?.let { fetchDetails(it) }
    }

    private fun fetchDetails(vo: HomeCharacterVO) {
        state.value = DetailViewModelState.Loaded(
            interactor.fetch(vo)
        )
    }
}