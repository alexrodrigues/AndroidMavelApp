package com.rodriguesalex.marvelapp.home.viewmodel

import androidx.lifecycle.MutableLiveData
import com.rodriguesalex.commoms.base.BaseViewModel
import com.rodriguesalex.commoms.di.AppSchedulers
import com.rodriguesalex.commoms.lifecycle.SingleLiveEvent
import com.rodriguesalex.marvelapp.home.data.HomeCharacterVO
import com.rodriguesalex.marvelapp.home.domain.HomeInteractor
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val interactor: HomeInteractor,
    private val appSchedulers: AppSchedulers
) : BaseViewModel() {

    val state = MutableLiveData<HomeViewModelState>()
    val command = SingleLiveEvent<HomeViewModelCommand>()
    val progressIsVisible = MutableLiveData<Boolean>()

    override fun onCreate() {
        super.onCreate()
        fetchCharacters()
    }

    private fun fetchCharacters() {
        compositeDisposable.add(
            interactor.fetchCharacters()
                .subscribeOn(appSchedulers.io)
                .observeOn(appSchedulers.main)
                .doOnSubscribe {
                    progressIsVisible.value = true
                }
                .doFinally {
                    progressIsVisible.value = false
                }
                .subscribe({
                    state.value = HomeViewModelState.Loaded(it)
                }, {
                    state.value = HomeViewModelState.Error
                    it.printStackTrace()
                })
        )
    }

    fun onItemClick(vo: HomeCharacterVO) {
        command.value = HomeViewModelCommand.OpenDetail(vo)
    }
}
