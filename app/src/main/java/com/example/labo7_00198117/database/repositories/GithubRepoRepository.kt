package com.example.labo7_00198117.database.repositories

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.labo7_00198117.database.daos.GithubRepoDAO
import com.example.labo7_00198117.database.entities.GithubRepo

class GithubRepoRepository(private val githubRepoDAO: GithubRepoDAO){
    fun getAll(): LiveData<List<GithubRepo>>  = githubRepoDAO.getAll()

    fun nuke() = githubRepoDAO.nukeTable()

    @WorkerThread
    suspend fun insert(githubRepo: GithubRepo){
        githubRepoDAO.insert(githubRepo)
    }
}