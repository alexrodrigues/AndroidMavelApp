package com.rodriguesalex.marvelapp.di.component

import android.app.Application
import com.rodriguesalex.commoms.di.ViewModelModule
import com.rodriguesalex.marvelapp.MarvelApplication
import com.rodriguesalex.marvelapp.di.module.ActivityBuilderModule
import com.rodriguesalex.marvelapp.di.module.AppModule
import com.rodriguesalex.marvelsdk.di.MarvelSdkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ViewModelModule::class,
    ActivityBuilderModule::class,
    MarvelSdkModule::class
])
interface AppComponent : AndroidInjector<MarvelApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
