package edu.tomerbu.lec17.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import edu.tomerbu.lec17.data.entity.Movie


@Dao
interface MovieDao {
    //REPLACE = update db from cloud
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(movies:List<Movie>)

    @Query("SELECT * FROM Movie")
    fun getMovies():LiveData<List<Movie>>
}