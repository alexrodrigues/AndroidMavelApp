package com.example.marvelapp

import com.example.marvelapp.di.component.DaggerAppComponent
import dagger.android.DaggerApplication

class MarvelApplication : DaggerApplication() {

    override fun applicationInjector() = DaggerAppComponent.builder()
        .application(this)
        .build()
}
