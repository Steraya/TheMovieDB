package com.example.challengechap7.view.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dzakyhdr.moviedb.data.remote.MovieRepository
import com.example.challengechap7.view.viewmodel.DetailViewModel

class DetailViewModelFactory (private val movieRepository: MovieRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        when {
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(movieRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
}