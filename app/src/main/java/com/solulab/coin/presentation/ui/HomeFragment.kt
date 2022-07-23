package com.solulab.coin.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.solulab.coin.R
import com.solulab.coin.databinding.FragmentHomeBinding
import com.solulab.coin.presentation.adapter.CoinAdapter
import com.solulab.coin.presentation.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModels<HomeViewModel>()
    private val adapter by lazy {
        CoinAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        viewModel.coinList.observe(viewLifecycleOwner) {
            Log.d("data_data", it.toString())
            adapter.submitList(it)
            binding.recycleView.adapter = adapter

        }
    }


}