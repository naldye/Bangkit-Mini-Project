package com.example.bangkitminiproject

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class movieViewAdapter(private val listMovie: ArrayList<Movie>): RecyclerView.Adapter<movieViewAdapter.movieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): movieViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_movies, parent, false)
        return movieViewHolder(view)
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: movieViewHolder, position: Int) {
        val (title, synopsis, poster, rating) = listMovie[position]
        holder.tvTitle.text = title
        holder.tvSynopsis.text = synopsis
        holder.imgPoster.setImageResource(poster)
        //holder.tvRating.text = rating


        holder.itemView.setOnClickListener(){
            val detailContext = holder.itemView.context
            val intentDetail = Intent(detailContext, DetailActivity::class.java)
            intentDetail.putExtra("key_movies", listMovie[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }

    }


    class movieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle : TextView = itemView.findViewById(R.id.text_title)
        val tvSynopsis : TextView = itemView.findViewById(R.id.text_synopsis)
        val imgPoster : ImageView = itemView.findViewById(R.id.img_poster)
        //val tvRating : TextView = itemView.findViewById(R.id.detail_ratingText)
    }

}