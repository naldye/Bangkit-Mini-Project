package com.example.bangkitminiproject

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_movies)


        val dataMovie= intent.getParcelableExtra("key_movies") as Movie?

        val tvDetailTitle : TextView = findViewById(R.id.detail_title)
        val tvDetailSynopsis : TextView = findViewById(R.id.detail_synopsis)
        val tvDetailPoster : ImageView = findViewById(R.id.detail_poster)
        val tvDetailReview : TextView = findViewById(R.id.detail_ratingText)

        if (dataMovie != null) {
            tvDetailTitle.text = dataMovie.title
        }
        if (dataMovie != null) {
            tvDetailSynopsis.text = dataMovie.synopsis
        }
        if (dataMovie != null) {
            tvDetailPoster.setImageResource(dataMovie.poster)
        }
        if (dataMovie != null) {
            tvDetailReview.text = dataMovie.rating
        }

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "Movie Detail"

    }
}
