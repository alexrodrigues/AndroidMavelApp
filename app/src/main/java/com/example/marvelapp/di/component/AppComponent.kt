package com.example.marvelapp.di.component

import android.app.Application
import com.example.marvelapp.MarvelApplication
import com.example.marvelapp.di.module.ActivityBuilderModule
import com.example.marvelapp.di.module.AppModule
import com.example.marvelapp.di.module.FragmentBuilderModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules =[
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityBuilderModule::class,
    FragmentBuilderModule::class])
interface AppComponent : AndroidInjector<MarvelApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}