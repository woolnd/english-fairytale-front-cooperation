package com.example.main

import androidx.appcompat.app.AppCompatActivity
import com.example.main.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreateDescription(): CharSequence? {
        return super.onCreateDescription()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}