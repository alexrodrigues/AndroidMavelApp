package com.rodriguesalex.commoms.base

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

open class BaseActivity: DaggerAppCompatActivity() {

    @field:Inject
    lateinit var factory: ViewModelProvider.Factory


    inline fun <reified VM : BaseViewModel> appViewModel(): VM {
        return ViewModelProviders.of(this, factory).get(VM::class.java)
    }

}