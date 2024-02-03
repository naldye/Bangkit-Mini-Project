package com.example.bangkitminiproject

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val title: String,
    val synopsis: String,
    val poster: Int,
    val rating: String,
):Parcelable
