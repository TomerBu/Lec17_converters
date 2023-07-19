package edu.tomerbu.lec17.data.repository

import edu.tomerbu.lec17.data.dao.MovieDao
import edu.tomerbu.lec17.data.entity.Movie
import edu.tomerbu.lec17.data.mapper.toMovie
import edu.tomerbu.lec17.service.TMDBService
import edu.tomerbu.lec17.service.dto.MovieDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepository(private val movieDao: MovieDao) {

    fun getMovies() = movieDao.getMovies()

    suspend fun refreshMovies() {
        withContext(Dispatchers.IO) {
            val movieResponse = TMDBService.create().getMovies()

            movieDao.add(movieResponse.movies.map(MovieDTO::toMovie))
        }
    }
}