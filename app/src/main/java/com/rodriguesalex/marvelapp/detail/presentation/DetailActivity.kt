package com.rodriguesalex.marvelapp.detail.presentation

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.rodriguesalex.commoms.base.BaseActivity
import com.rodriguesalex.marvelapp.R
import com.rodriguesalex.marvelapp.databinding.ActivityDetailBinding
import com.rodriguesalex.marvelapp.detail.viewmodel.DetailViewModel

class DetailActivity : BaseActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val viewModel by lazy { appViewModel<DetailViewModel>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityDetailBinding>(this, R.layout.activity_detail).apply {
            lifecycleOwner = this@DetailActivity
            vm = viewModel
        }
    }
}
