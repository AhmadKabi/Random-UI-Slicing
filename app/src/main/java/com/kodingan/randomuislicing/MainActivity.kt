package com.kodingan.randomuislicing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /*1*/ buildItemStoryMine()

    }

    private fun inflateLayout(layoutRes: Int): View {
        val root = findViewById<FrameLayout>(R.id.container)

        return layoutInflater.inflate(
            layoutRes,
            root,
            false
        )

    }

    private fun buildItemStoryMine() {
        val inflatedLayout = inflateLayout(R.layout.item_story_mine)

        val image = inflatedLayout.findViewById<AppCompatImageView>(R.id.image)
        Glide.with(this)
            .load(R.drawable.cat)
            .apply(RequestOptions.circleCropTransform())
            .into(image)

    }

}