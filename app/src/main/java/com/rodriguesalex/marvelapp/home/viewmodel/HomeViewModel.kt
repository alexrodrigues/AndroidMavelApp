package com.rodriguesalex.marvelapp.home.viewmodel

import androidx.lifecycle.MutableLiveData
import com.rodriguesalex.commoms.base.BaseViewModel
import com.rodriguesalex.commoms.di.AppSchedulers
import com.rodriguesalex.marvelapp.home.domain.HomeInteractor
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val interactor: HomeInteractor,
    private val appSchedulers: AppSchedulers
) : BaseViewModel() {

    val state = MutableLiveData<HomeViewModelState>()

    override fun onCreate() {

        fetchCharacters()
    }

    private fun fetchCharacters() {
        compositeDisposable.add(
            interactor.fetchCharacters()
                .subscribeOn(appSchedulers.io)
                .observeOn(appSchedulers.main)
                .subscribe({
                }, {
                    it.printStackTrace()
                })
        )
    }
}
