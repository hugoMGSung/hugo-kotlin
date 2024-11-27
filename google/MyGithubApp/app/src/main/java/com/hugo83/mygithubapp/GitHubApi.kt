package com.hugo83.mygithubapp

import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {
    @GET("users/{username}")
    suspend fun getUser(@Path("username") username: String): GitHubUser
}

data class GitHubUser(
    val login: String,
    val name: String?,
    val avatar_url: String,
    val public_repos: Int,
    val followers: Int,
    val following: Int
)