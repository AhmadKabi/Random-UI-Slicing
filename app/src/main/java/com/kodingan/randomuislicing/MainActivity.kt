package com.kodingan.randomuislicing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buildItemStoryMine()

    }

    private fun buildItemStoryMine(){
        val image = findViewById<AppCompatImageView>(R.id.image)
        Glide.with(this)
            .load(R.drawable.cat)
            .apply(RequestOptions.circleCropTransform())
            .into(image)
    }

}