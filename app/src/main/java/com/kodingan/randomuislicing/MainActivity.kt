package com.kodingan.randomuislicing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kodingan.randomuislicing.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

}