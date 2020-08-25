package com.example.marvelapp.features.home.container

import android.os.Bundle
import android.widget.Toast
import com.example.marvelapp.R
import com.example.marvelsdk.characters.CharactersRepository
import com.rodriguesalex.commoms.di.AppSchedulers
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var repository: CharactersRepository

    @Inject
    lateinit var appSchedulers: AppSchedulers

    private val compositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        compositeDisposable.add(
            repository.fetchCharacters()
                .observeOn(appSchedulers.main)
                .subscribeOn(appSchedulers.io)
                .subscribe({
                    Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()
                }, {
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                })
        )
    }

    override fun onPause() {
        super.onPause()
        compositeDisposable.dispose()
    }
}
