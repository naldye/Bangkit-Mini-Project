package com.example.bangkitminiproject

import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val myProfileIMage = findViewById<CircleImageView>(R.id.myPicture)
        Picasso.get()
            .load(R.drawable.fotofio)
            .resize(400, 400)
            .centerCrop(Gravity.TOP)
            .into(myProfileIMage)

        val myProfileName = findViewById<TextView>(R.id.myName)
        myProfileName.text = "Fionaldy Andrianus Manik"

        val myProfileEmail = findViewById<TextView>(R.id.myEmail)
        myProfileEmail.text = "asiankidd2802@gmail.com"

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "About"

    }
}