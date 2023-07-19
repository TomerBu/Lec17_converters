package edu.tomerbu.lec17.service

import edu.tomerbu.lec17.service.dto.MovieResponse
import edu.tomerbu.lec17.utils.TokenInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {

    @GET("discover/movie")
    suspend fun getMovies(): MovieResponse

    companion object {
        fun create(): TMDBService {
            //תופס את כל הבקשות ומדפיס ללוג
            val logger = HttpLoggingInterceptor()
            logger.level = HttpLoggingInterceptor.Level.BODY

            // תופס את כל הבקשות ומוסיף Api Key
            val client = OkHttpClient.Builder()
                .addInterceptor(TokenInterceptor())
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .client(client)
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(TMDBService::class.java)
        }
    }
}

//https://api.themoviedb.org/3/discover/movie?api_key=b3b1492d3e91e9f9403a2989f3031b0c