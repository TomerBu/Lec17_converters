package edu.tomerbu.lec17.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.tomerbu.lec17.data.AppDatabase
import edu.tomerbu.lec17.data.repository.MovieRepository
import kotlinx.coroutines.launch

class HomeViewModel(private val context: Application) : AndroidViewModel(context) {
    //init the database:
    private val db = AppDatabase.create(context)

    //get dao
    private val dao = db.movieDao()

    //init the repo:
    private val repo = MovieRepository(dao)

    //LiveData from database:
    val movies = repo.getMovies()

    init {
        viewModelScope.launch {
            //refresh from the api:
            repo.refreshMovies()
        }
    }
}