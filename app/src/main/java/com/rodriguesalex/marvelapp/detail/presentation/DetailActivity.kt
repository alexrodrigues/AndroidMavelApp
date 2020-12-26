package com.rodriguesalex.marvelapp.detail.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.rodriguesalex.commoms.base.BaseActivity
import com.rodriguesalex.marvelapp.R
import com.rodriguesalex.marvelapp.databinding.ActivityDetailBinding
import com.rodriguesalex.marvelapp.detail.viewmodel.DetailViewModel
import com.rodriguesalex.marvelapp.detail.viewmodel.DetailViewModelState
import com.rodriguesalex.marvelapp.home.data.HomeCharacterVO
import com.squareup.picasso.Picasso

class DetailActivity : BaseActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val viewModel by lazy { appViewModel<DetailViewModel>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityDetailBinding>(this, R.layout.activity_detail).apply {
            lifecycleOwner = this@DetailActivity
            vm = viewModel
        }

        setupObservers()
    }

    private fun setupObservers() {
        viewModel.state.observe(this, Observer { state ->
            when(state) {
                is DetailViewModelState.Loaded ->
                    setupView(state.vo)
            }
        })
    }

    private fun setupView(vo: HomeCharacterVO) {
        Picasso.get().load(vo.urlImage).into(binding.expandedImage)

        binding.toolbar.title = vo.name
        setSupportActionBar(binding.toolbar)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        const val BUNDLE_VO = "DETAIL_VO"

        fun intent(context: Context, vo: HomeCharacterVO) =
            Intent(context, DetailActivity::class.java).apply {
                putExtra(BUNDLE_VO, vo)
            }
    }
}
