package com.rodriguesalex.marvelapp.home.di

import androidx.lifecycle.ViewModel
import com.rodriguesalex.commoms.di.ViewModelKey
import com.rodriguesalex.marvelapp.di.scope.ActivityScope
import com.rodriguesalex.marvelapp.home.domain.HomeInteractor
import com.rodriguesalex.marvelapp.home.domain.HomeInteractorImpl
import com.rodriguesalex.marvelapp.home.presentation.HomeActivity
import com.rodriguesalex.marvelapp.home.viewmodel.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class HomeContributeModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun homeActivity(): HomeActivity
}

@Module
abstract class HomeModule {

    @ActivityScope
    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    abstract fun provideHomeInteractor(interactor: HomeInteractorImpl): HomeInteractor
}
