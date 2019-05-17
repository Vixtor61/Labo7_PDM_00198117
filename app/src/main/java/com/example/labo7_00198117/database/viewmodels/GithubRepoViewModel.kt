package com.example.labo7_00198117.database.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.labo7_00198117.database.RoomDb
import com.example.labo7_00198117.database.entities.GithubRepo
import com.example.labo7_00198117.database.repositories.GithubRepoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GithubRepoViewModel(application: Application): AndroidViewModel(application){
    private val repoRepository: GithubRepoRepository

    init {
        val repoDao = RoomDb.getInstance(application).repoDAO()
        repoRepository = GithubRepoRepository(repoDao)
    }

    fun getAll():LiveData<List<GithubRepo>> = repoRepository.getAll()
    fun insert(repo: GithubRepo) = viewModelScope.launch(Dispatchers.IO){

        repoRepository.insert(repo)

    }

}