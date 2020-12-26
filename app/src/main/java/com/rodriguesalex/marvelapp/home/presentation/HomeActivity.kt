package com.rodriguesalex.marvelapp.home.presentation

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.rodriguesalex.commoms.base.BaseActivity
import com.rodriguesalex.marvelapp.R
import com.rodriguesalex.marvelapp.databinding.ActivityHomeBinding
import com.rodriguesalex.marvelapp.detail.presentation.DetailActivity
import com.rodriguesalex.marvelapp.home.data.HomeCharacterVO
import com.rodriguesalex.marvelapp.home.presentation.adapters.HomeAdapter
import com.rodriguesalex.marvelapp.home.viewmodel.HomeViewModel
import com.rodriguesalex.marvelapp.home.viewmodel.HomeViewModelCommand
import com.rodriguesalex.marvelapp.home.viewmodel.HomeViewModelState

class HomeActivity : BaseActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val viewModel by lazy { appViewModel<HomeViewModel>() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityHomeBinding>(this, R.layout.activity_home).apply {
            lifecycleOwner = this@HomeActivity
            vm = viewModel
        }

        setupObservers()
    }

    private fun setupObservers() {
        viewModel.state.observe(this, Observer { state ->
            when (state) {
                is HomeViewModelState.Loaded ->
                    setupRecyclerView(state.list)

                HomeViewModelState.Error -> {
                    // TODO: Implement error
                }
            }
        })

        viewModel.command.observe(this, Observer {  command ->
            when(command) {
                is HomeViewModelCommand.OpenDetail ->
                    startActivity(
                        DetailActivity.intent(this, command.vo)
                    )
            }
        })
    }

    private fun setupRecyclerView(list: List<HomeCharacterVO>) {
        with(binding.rvHome) {
            layoutManager = LinearLayoutManager(this@HomeActivity)
            with(HomeAdapter(list)) {
                adapter = this
                onItemClickListener = { viewModel.onItemClick(it) }
            }
        }
    }
}
