package dev.matyaqubov.githubclone.repository.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dev.matyaqubov.githubclone.repository.HomeRepository
import dev.matyaqubov.githubclone.ui.fragments.home.HomeViewModel

class HomeViewModelFactory(private val repository: HomeRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class $modelClass")
    }
}