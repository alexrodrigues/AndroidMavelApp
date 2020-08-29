package com.rodriguesalex.marvelapp.di.module

import android.app.Application
import android.content.res.Resources
import com.rodriguesalex.commoms.di.AppSchedulers
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideResources(application: Application): Resources {
        return application.resources
    }

    @Provides
    @Singleton
    fun providechedulers(): AppSchedulers = AppSchedulers()
}
