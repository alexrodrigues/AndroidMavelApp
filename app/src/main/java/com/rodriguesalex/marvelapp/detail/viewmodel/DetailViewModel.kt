package com.rodriguesalex.marvelapp.detail.viewmodel

import androidx.lifecycle.MutableLiveData
import com.rodriguesalex.commoms.base.BaseViewModel
import com.rodriguesalex.commoms.di.AppSchedulers
import com.rodriguesalex.marvelapp.home.data.HomeCharacterVO
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    private val vo: HomeCharacterVO?,
    private val appSchedulers: AppSchedulers
): BaseViewModel() {

    val state = MutableLiveData<DetailViewModelState>()

    override fun onCreate() {
        super.onCreate()
        vo?.let { state.value = DetailViewModelState.Loaded(it) }
    }

}