package com.rodriguesalex.marvelapp.di.module

import com.rodriguesalex.marvelapp.detail.di.DetailContributeModule
import com.rodriguesalex.marvelapp.home.di.HomeContributeModule
import dagger.Module

@Module(includes = [
    HomeContributeModule::class,
    DetailContributeModule::class
])
class FeatureModule