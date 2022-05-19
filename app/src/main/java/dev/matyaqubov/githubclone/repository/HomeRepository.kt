package dev.matyaqubov.githubclone.repository

import dev.matyaqubov.githubclone.data.remote.ApiService

class HomeRepository(
    private val apiService: ApiService,
//    private val dao:Dao
) {
    suspend fun getRepositories() = apiService.getRepositories()
}