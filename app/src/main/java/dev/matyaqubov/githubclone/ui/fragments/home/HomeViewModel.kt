package dev.matyaqubov.githubclone.ui.fragments.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.matyaqubov.githubclone.model.Repository
import dev.matyaqubov.githubclone.repository.HomeRepository
import dev.matyaqubov.githubclone.utils.UiStateList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: HomeRepository) : ViewModel() {

    private val _repositories = MutableStateFlow<UiStateList<Repository>>(UiStateList.EMPTY)

    val repositories = _repositories

    fun getRepositories() = viewModelScope.launch {
        _repositories.value = UiStateList.LOADING

        try {
            val response = repository.getRepositories()
            _repositories.value = UiStateList.SUCCESS(response)
        } catch (e: Exception) {
            _repositories.value = UiStateList.ERROR(e.localizedMessage ?: "No Connection")
        }
    }

}