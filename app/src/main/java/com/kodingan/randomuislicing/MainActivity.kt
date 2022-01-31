package com.kodingan.randomuislicing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kodingan.randomuislicing.databinding.ActivityMainBinding
import com.kodingan.randomuislicing.databinding.ScreenIgStoryBinding
import com.kodingan.view.IGStoryView.Companion.stateUnread

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*1*/ buildItemStory()

    }

    private fun buildItemStory() {
        val binding = ScreenIgStoryBinding.inflate(
            layoutInflater,
            binding.container,
            true
        )

        binding.igStoryView.setOnClickListener {
            binding.igStoryView.setState(stateUnread)
        }
        
    }

}