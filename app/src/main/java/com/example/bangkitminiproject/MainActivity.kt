package com.example.bangkitminiproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvMovie: RecyclerView
    private val listMovie = ArrayList<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMovie = findViewById(R.id.rv_movies)
        rvMovie.setHasFixedSize(true)

        listMovie.addAll(getlistMovies())
        showRecyclerList()

    }

    @SuppressLint("Recycle")
    private fun getlistMovies(): ArrayList<Movie> {
        val dataTitle = resources.getStringArray(R.array.data_title)
        val dataSynopsis = resources.getStringArray(R.array.data_synopsis)
        val dataPoster = resources.obtainTypedArray(R.array.data_poster)
        val dataRating = resources.getStringArray(R.array.data_movieRatings)
        val listMovie = ArrayList<Movie>()
        for (i in dataTitle.indices) {
            val movies = Movie(dataTitle[i], dataSynopsis[i], dataPoster.getResourceId(i, -1)
            , dataRating[i])
            listMovie.add(movies)
        }
        return listMovie
    }

    private fun showRecyclerList() {
        rvMovie.layoutManager = LinearLayoutManager(this)
        val listMovieAdapter = movieViewAdapter(listMovie)
        rvMovie.adapter = listMovieAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = MenuInflater(this)
        inflater.inflate(R.menu.about_button, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this, AboutActivity::class.java)

        when (item.itemId) {
            R.id.aboutButton -> {
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }

    }
}