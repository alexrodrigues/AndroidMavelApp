package com.example.marvelapp.di.module

import com.example.marvelapp.di.scope.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {
//    @ActivityScope
//    @ContributesAndroidInjector(modules = [MainModule::class])
//    internal abstract fun mainActivity(): MainActivity
}