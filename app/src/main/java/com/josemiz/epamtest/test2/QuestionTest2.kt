package com.josemiz.epamtest.test2

import test2.MovieInPlatform

object QuestionTest2 {

    fun getMoviesInPlatforms(movies:List<Movie>, platforms:List<Platform>):List<MovieInPlatform>{
        val moviesById = movies.associateBy { it.movieId }

        val result = platforms.filter { moviesById[it.movieId] != null }.mapNotNull { platform ->
            moviesById[platform.movieId]?.let { movie ->
                MovieInPlatform(movie.movieId, movie.title, platform.inService1, platform.inService2)
            }
        }
        return result
    }
}