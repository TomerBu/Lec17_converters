package edu.tomerbu.lec17.data.converters

import androidx.room.TypeConverter


/**
 * given a list<T> => "item1,item2,item3"
 */
fun <T> List<T>.toShortString() =
    joinToString(separator = ",") { "$it" }


class MovieConverters {

    @TypeConverter
    /**
     * a method that takes List<Int> and returns a String "1,23,44"
     */
    fun genreIdsToString(genreIds: List<Int>): String {
        return genreIds.toShortString()
    }

    @TypeConverter
    fun stringToGenreIds(string: String): List<Int> {
        return string.split(",").map { it.toInt() }
    }
}