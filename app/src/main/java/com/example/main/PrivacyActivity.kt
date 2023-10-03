package com.example.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.main.databinding.ActivityPrivacyBinding

class PrivacyActivity: AppCompatActivity() {

    lateinit var binding: ActivityPrivacyBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPrivacyBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.backIv.setOnClickListener {
            finish()
        }
    }
}