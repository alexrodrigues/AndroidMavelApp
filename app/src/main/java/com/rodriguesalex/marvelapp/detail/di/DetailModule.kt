package com.rodriguesalex.marvelapp.detail.di

import androidx.lifecycle.ViewModel
import com.rodriguesalex.commoms.di.ViewModelKey
import com.rodriguesalex.marvelapp.detail.data.DetailRepository
import com.rodriguesalex.marvelapp.detail.data.DetailRepositoryImpl
import com.rodriguesalex.marvelapp.detail.domain.DetailInteractor
import com.rodriguesalex.marvelapp.detail.domain.DetailInteractorImpl
import com.rodriguesalex.marvelapp.detail.presentation.DetailActivity
import com.rodriguesalex.marvelapp.detail.viewmodel.DetailViewModel
import com.rodriguesalex.marvelapp.di.scope.ActivityScope
import com.rodriguesalex.marvelapp.home.data.HomeCharacterVO
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
abstract class DetailContributeModule {
    @ActivityScope
    @ContributesAndroidInjector(modules = [DetailModule::class])
    abstract fun detailActivity(): DetailActivity
}

@Module
abstract class DetailModule {

    @ActivityScope
    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    abstract fun bindDetailViewModel(viewModel: DetailViewModel): ViewModel

    @Binds
    abstract fun provideInteractor(interactor: DetailInteractorImpl): DetailInteractor

    @Binds
    abstract fun provideRepository(repository: DetailRepositoryImpl): DetailRepository

    @Module
    companion object {
        @JvmStatic
        @Singleton
        @Provides
        fun provideHomeVo(activity: DetailActivity): HomeCharacterVO? =
            activity.intent.getParcelableExtra(DetailActivity.BUNDLE_VO)
    }
}