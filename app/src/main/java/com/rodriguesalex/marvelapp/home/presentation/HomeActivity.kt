package com.rodriguesalex.marvelapp.home.presentation

import android.content.res.Resources
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.rodriguesalex.commoms.base.BaseActivity
import com.rodriguesalex.marvelapp.R
import com.rodriguesalex.marvelapp.databinding.ActivityHomeBinding
import com.rodriguesalex.marvelapp.home.viewmodel.HomeViewModel
import com.rodriguesalex.marvelapp.home.viewmodel.HomeViewModelState
import javax.inject.Inject

class HomeActivity : BaseActivity() {

    @Inject
    lateinit var resources3: Resources

    private lateinit var binding: ActivityHomeBinding
    private val viewModel by lazy { appViewModel<HomeViewModel>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)

        binding.lifecycleOwner = this
        binding.vm = viewModel

        setupObservers()
    }

    private fun setupObservers() {
        viewModel.state.observe(this, Observer { state ->
            when (state) {
                is HomeViewModelState.Loaded ->
                    Toast.makeText(this, state.list.toString(), Toast.LENGTH_LONG).show()
            }
        })
    }
}
