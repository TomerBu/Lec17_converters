package edu.tomerbu.lec17.data.mapper

import edu.tomerbu.lec17.data.entity.Movie
import edu.tomerbu.lec17.service.dto.MovieDTO
const val TMDB_IMAGE_URL = "https://image.tmdb.org/t/p/w500/"
//dto mapping
fun MovieDTO.toMovie() = Movie(
    id = id,
    title = title,
    overview = overview,
    posterUrl = "$TMDB_IMAGE_URL$posterPath",
    backdropUrl = "$TMDB_IMAGE_URL$backdropPath",
    adult = adult,
  //  genreIds = genreIds,
    originalLanguage = originalLanguage,
    originalTitle = originalTitle,
    popularity = popularity,
    releaseDate = releaseDate,
    video = video,
    voteAverage = voteAverage,
    voteCount = voteCount
)