package br.com.zup.movieflix.moviedetail.datasource

import android.app.Application
import android.content.Context
import android.widget.Toast
import br.com.zup.movieflix.*
import br.com.zup.movieflix.home.model.Movie
import br.com.zup.movieflix.moviedetail.model.DirectorModel


class DirectorLocalDataSource(private val application: Application) {

    fun getSharedPrefs(movie: Movie): Boolean {
        val prefs = application.getSharedPreferences(FAVORITE, Context.MODE_PRIVATE)
        return prefs.getBoolean(movie.title, false)
    }

    fun saveSharedPrefs(movie: Movie, favorite: Boolean) {
        application.getSharedPreferences(FAVORITE, Context.MODE_PRIVATE).edit().apply {
            putBoolean(movie.title, favorite)
            apply()
        }
    }

    val directorList = mutableListOf(
        DirectorModel(
            TARANTINO,
            TARANTINO_INFO
        ),
        DirectorModel(
            MARTIN_SCORSESE,
            MARTIN_SCORSESE_INFO
        )
    )
}