package com.rodriguesalex.marvelapp.di.component

import android.app.Application
import com.rodriguesalex.marvelapp.MarvelApplication
import com.rodriguesalex.marvelapp.di.module.ActivityBuilderModule
import com.rodriguesalex.marvelapp.di.module.AppModule
import com.rodriguesalex.marvelapp.di.module.FragmentBuilderModule
import com.rodriguesalex.marvelsdk.di.MarvelSdkModule
import com.rodriguesalex.commoms.di.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ActivityBuilderModule::class,
    FragmentBuilderModule::class,
    ViewModelModule::class,
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
