package dev.matyaqubov.githubclone.ui.fragments.home

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import dev.matyaqubov.githubclone.R
import dev.matyaqubov.githubclone.data.remote.ApiClient
import dev.matyaqubov.githubclone.data.remote.ApiService
import dev.matyaqubov.githubclone.repository.HomeRepository
import dev.matyaqubov.githubclone.repository.factory.HomeViewModelFactory
import dev.matyaqubov.githubclone.ui.fragments.BaseFragment
import dev.matyaqubov.githubclone.utils.UiStateList

class HomeFragment : BaseFragment(R.layout.fragment_home) {
    private lateinit var viewModel: HomeViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewModel()
        viewModel.getRepositories()

        setupObservers()
    }

    private fun setupObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.repositories.collect {
                when (it) {
                    is UiStateList.LOADING -> {
                        //showProgress
                    }
                    is UiStateList.SUCCESS -> {
                        //Uiga  bog'lanadi
                        Log.d("SUCCESS", "setupObservers: ${it.data} ${it.data.size}")
                    }
                    is UiStateList.ERROR -> {
                        Toast.makeText(requireContext(), "${it.message}", Toast.LENGTH_SHORT).show()
                    }
                    else -> Unit

                }
            }
        }
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(
            this,
            HomeViewModelFactory(HomeRepository(ApiClient.createServiceWithAuth(ApiService::class.java)))
        )[HomeViewModel::class.java]
    }


}