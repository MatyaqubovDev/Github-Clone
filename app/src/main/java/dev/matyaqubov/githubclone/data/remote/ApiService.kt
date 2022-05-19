package dev.matyaqubov.githubclone.data.remote

import dev.matyaqubov.githubclone.model.Repository
import retrofit2.http.GET

interface ApiService {
    @GET("user/repos")
    suspend fun getRepositories(): List<Repository>
}