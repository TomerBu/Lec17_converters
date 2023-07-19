package edu.tomerbu.lec17.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import edu.tomerbu.lec17.data.dao.MovieDao
import edu.tomerbu.lec17.data.entity.Movie

const val DB_VERSION = 1
const val DB_NAME = "AppDatabase"

@Database(entities = [Movie::class], version = DB_VERSION)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    companion object {
        fun create(context: Context) = Room
            .databaseBuilder(context, AppDatabase::class.java, DB_NAME)
            .build()
    }
}
//CREATE DATABASE AppDatabase;