package com.example.marvelapp.di.module

import com.example.marvelapp.di.scope.ActivityScope
import com.example.marvelapp.features.home.container.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun homeActivity(): HomeActivity
}
