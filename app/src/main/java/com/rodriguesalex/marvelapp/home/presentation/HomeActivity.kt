package com.rodriguesalex.marvelapp.home.presentation

import android.content.res.Resources
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.rodriguesalex.commoms.base.BaseActivity
import com.rodriguesalex.marvelapp.R
import com.rodriguesalex.marvelapp.databinding.ActivityHomeBinding
import com.rodriguesalex.marvelapp.home.viewmodel.HomeViewModel
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

    }

}
